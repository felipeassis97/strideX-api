package com.snapshoes.store.presentation.dtos.mappers

import jakarta.persistence.EntityManager
import org.springframework.stereotype.Component
import com.snapshoes.store.persistence.entities.*
import com.snapshoes.store.config.interfaces.Mapper
import com.snapshoes.store.presentation.dtos.request.product.CreateProductDto
import com.snapshoes.store.presentation.dtos.response.product.ProductDto

@Component
class ProductMapper(
    private val sizeMapper: SizeMapper,
    private val genreMapper: GenreMapper,
    private val brandMapper: BrandMapper,
    private val entityManager: EntityManager,
    private val productSizeMapper: ProductSizeMapper,
    private val productImageMapper: ProductImageMapper,
    private val productGenreMapper: ProductGenreMapper,

    ) : Mapper<Product, ProductDto> {

    override fun toDto(entity: Product): ProductDto {
        return ProductDto(
            id = entity.id,
            storeId = entity.store.id,
            title = entity.title,
            description = entity.description,
            price = entity.price,
            quantity = entity.quantity,
            brand = BrandMapper().toDto(entity.brand),
            images = entity.images.map { productImageMapper.toDto(it) },
            sizes = entity.productSizes.map { sizeMapper.toDto(it.size) },
            genres = entity.productGenres.map { genreMapper.toDto(it.genre) }
        )
    }

    override fun toEntity(dto: ProductDto): Product {
        val storeRef = entityManager.getReference(Store::class.java, dto.storeId)

        return Product(
            id = dto.id,
            store = storeRef,
            title = dto.title,
            description = dto.description,
            price = dto.price,
            quantity = dto.quantity,
            brand = brandMapper.toEntity(dto.brand),
            images = dto.images.map { productImageMapper.toEntity(it) },
            productSizes = dto.sizes.map {
                productSizeMapper.sizeDtoToEntity(it, dto.id)
            },
            productGenres = dto.genres.map { productGenreMapper.genreDtoToEntity(it, dto.id) },
        )
    }

    fun createProductToEntity(
        entity: Product,
        images: List<ProductImage>,
        genres: List<ProductGenre>,
        sizes: List<ProductSize>
    ): ProductDto {
        return ProductDto(
            id = entity.id,
            storeId = entity.store.id,
            title = entity.title,
            description = entity.description,
            price = entity.price,
            quantity = entity.quantity,
            brand = BrandMapper().toDto(entity.brand),
            images = images.map { productImageMapper.toDto(it) },
            sizes = sizes.map { sizeMapper.toDto(it.size) },
            genres = genres.map { genreMapper.toDto(it.genre) }
        )
    }


    fun createSimpleProductToEntity(dto: CreateProductDto, brand: Brand, store: Store): Product {
        return Product(
            title = dto.title,
            description = dto.description,
            price = dto.price,
            quantity = dto.quantity,
            store = store,
            brand = brand
        )
    }
}





