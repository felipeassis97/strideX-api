package com.snapshoes.store.service

import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.data.domain.Pageable
import com.snapshoes.store.persistense.repositories.*
import org.springframework.cache.annotation.Cacheable
import org.springframework.cache.annotation.CacheEvict
import org.springframework.data.jpa.domain.Specification
import com.snapshoes.store.persistense.entities.ProductSize
import com.snapshoes.store.persistense.entities.ProductGenre
import com.snapshoes.store.persistense.entities.ProductImage
import com.snapshoes.store.config.exceptions.NotFoundException
import org.springframework.transaction.annotation.Transactional
import com.snapshoes.store.presentation.dtos.mappers.SizeMapper
import com.snapshoes.store.presentation.dtos.mappers.BrandMapper
import com.snapshoes.store.presentation.dtos.mappers.GenreMapper
import com.snapshoes.store.presentation.dtos.mappers.ProductMapper
import com.snapshoes.store.presentation.dtos.response.product.ProductDto
import com.snapshoes.store.persistense.specifications.ProductSpecifications
import com.snapshoes.store.presentation.dtos.request.product.CreateProductDto
import com.snapshoes.store.presentation.dtos.request.product.UpdateProductDto

@Service
class ProductService(
    private val sizeMapper: SizeMapper,
    private val genreMapper: GenreMapper,
    private val brandMapper: BrandMapper,
    private val productMapper: ProductMapper,
    private val sizeRepository: SizeRepository,
    private val storeRepository: StoreRepository,
    private val brandRepository: BrandRepository,
    private val genreRepository: GenreRepository,
    private val productRepository: ProductRepository,
    private val productSizeRepository: ProductSizeRepository,
    private val productGenreRepository: ProductGenreRepository,
    private val productImageRepository: ProductImageRepository,
) {
    @Cacheable(cacheNames = ["Products"], key = "#root.method.name")
    fun getAll(storeId: Long?, brandId: Long?, name: String?, pageable: Pageable): Page<ProductDto> {
        val products = productRepository.findAll(
            Specification.where(
                storeId?.let { ProductSpecifications.hasStoreId(it) })
                .and(brandId?.let { ProductSpecifications.hasBrandId(it) })
                .and(name?.let { ProductSpecifications.hasName(it) }),
            pageable
        )
        return products.map { productMapper.toDto(it) }
    }

    @Transactional
    @CacheEvict(cacheNames = ["Products"], allEntries = true)
    fun createProduct(form: CreateProductDto): Long {
        // Valid store
        val store = storeRepository.findById(form.storeId).orElseThrow {
            NotFoundException("Store not found with ID: ${form.storeId}")
        }

        //Valid brand
        val brand = form.brand.id?.let {
            brandRepository.findById(it).orElseThrow {
                NotFoundException("Brand not found with ID: $it")
            }
        } ?: throw NotFoundException("Brand ID must be provided")

        val currentProduct = productMapper.createSimpleProductToEntity(form, brand, store)
        val savedProduct = productRepository.save(currentProduct)

        //Valid and save product sizes
        val sizes = form.sizes.map {
            it.id?.let { it1 ->
                sizeRepository.findById(it1)
                    .orElseThrow {
                        NotFoundException("Size not found with: $it")
                    }
            }
            ProductSize(
                product = savedProduct,
                size = sizeMapper.createSizeDtoToEntity(it),
            )
        }
        productSizeRepository.saveAll(sizes)


        // Valid and save product genres
        val genres = form.genres.map {
            it.id?.let { it1 ->
                genreRepository.findById(it1)
                    .orElseThrow {
                        NotFoundException("Genre not found with: $it")
                    }
            }
            ProductGenre(
                product = savedProduct,
                genre = genreMapper.createGenreToEntity(it.id, it)
            )
        }
        productGenreRepository.saveAll(genres)

        // Save product images
        val images = form.images.map {
            ProductImage(
                product = savedProduct,
                url = it.url
            )
        }
        productImageRepository.saveAll(images)

        savedProduct.id?.let {
            return it
        } ?: throw NotFoundException("Store ID no found")
    }

    fun findProductWithImagesAndGenres(id: Long): ProductDto {
        val product = productRepository.findById(id).orElseThrow { RuntimeException("Product not found") }
        val images = productImageRepository.findImagesByProductId(id)
        val genres = productGenreRepository.findGenresByProductId(id)
        val sizes = productSizeRepository.findSizesByProductId(id)

        return productMapper.createProductToEntity(product, images, genres, sizes)
    }

    @CacheEvict(cacheNames = ["Products"], allEntries = true)
    fun deleteProductById(id: Long) {
        // Valid product
        val product = productRepository.findById(id).orElseThrow {
            NotFoundException("Product not found with ID: $id")
        }

        productImageRepository.deleteByProductId(id)
        productGenreRepository.deleteByProductId(id)
        productRepository.delete(product)
    }

    @Transactional
    @CacheEvict(cacheNames = ["Products"], allEntries = true)
    fun patchProduct(id: Long, form: UpdateProductDto) {
        val product = productRepository.findById(id).orElseThrow {
            NotFoundException("Product not found with ID: $id")
        }

        form.title?.let { product.title = it }
        form.price?.let { product.price = it }
        form.description?.let { product.description = it }
        form.quantity?.let { product.quantity = it }

        form.brand?.let {
            val validateBrand = it.id?.let { it1 -> brandRepository.existsById(it1) }
            if (validateBrand == true) {
                val brand = brandMapper.createBrandToEntity(product.brand.id, it)
                product.brand = brandRepository.save(brand)
            }
        }

        form.sizes?.let {
            product.id?.let { it1 -> productSizeRepository.deleteByProductId(it1) }

            val productSizes = it.map { sizeDto ->
                ProductSize(
                    product = product,
                    size = sizeMapper.createSizeDtoToEntity(sizeDto)
                )
            }
            productSizeRepository.saveAll(productSizes)
        }

        form.images?.let {
            it.map { imageDto ->
                if (imageDto.id != null) {
                    productImageRepository.updateImageUrl(imageDto.id, imageDto.url)
                } else {
                    val image = ProductImage(
                        product = product,
                        url = imageDto.url
                    )
                    productImageRepository.save(image)
                }
            }
        }

        form.genres?.let {
            product.id?.let { it1 -> productGenreRepository.deleteByProductId(it1) }
            val productGenres = it.map { genreDto ->
                ProductGenre(
                    product = product,
                    genre = genreMapper.createGenreToEntity(genreDto.id, genreDto)
                )
            }
            productGenreRepository.saveAll(productGenres)
        }

        //Save product updated
        productRepository.save(product)
    }
}