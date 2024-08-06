package com.snapshoes.store.presentation.mappers

import Mapper
import com.snapshoes.store.ProductGenreDto
import com.snapshoes.store.persistense.entities.*
import com.snapshoes.store.presentation.dtos.ProductDto
import com.snapshoes.store.presentation.dtos.ProductImageDto
import com.snapshoes.store.presentation.dtos.ProductSizeDto
import com.snapshoes.store.presentation.dtos.SizeDto
import org.springframework.stereotype.Component

@Component
class ProductMapper : Mapper<Product, ProductDto> {
    override fun map(t: Product): ProductDto {
         val brandMapper = BrandMapper()

        return ProductDto(
            id = t.id,
            storeId = t.store.id,
            title = t.title,
            description = t.description,
            price = t.price,
            quantity = t.quantity,
            brand = brandMapper.map( t.brand),
            images = t.images.map { ProductImageMapper().map(it) },
            sizes = t.productSizes.map { SizeMapper().map(it.size) },
            genres = t.productGenres.map { GenreMapper().map(it.genre) }
        )
    }
}

@Component
class ProductImageMapper : Mapper<ProductImage, ProductImageDto> {
    override fun map(t: ProductImage): ProductImageDto {
        return ProductImageDto(
            id = t.id,
            url = t.url,
        )
    }
}

@Component
class ProductSizeMapper : Mapper<ProductSize, ProductSizeDto> {
    override fun map(t: ProductSize): ProductSizeDto {
       val sizeMapper = SizeMapper()
        return ProductSizeDto(
            productId = t.product.id,
            size = sizeMapper.map(t.size)
        )
    }
}

@Component
class SizeMapper : Mapper<Size, SizeDto> {
    override fun map(t: Size): SizeDto {
        return SizeDto(
            id = t.id,
            size = t.size,
        )
    }
}

@Component
class ProductGenreMapper : Mapper<ProductGenre, ProductGenreDto> {
    override fun map(t: ProductGenre): ProductGenreDto {
        val genreMapper = GenreMapper()
        return ProductGenreDto(
            productId = t.product.id,
            genre =   genreMapper.map(t.genre),
        )
    }
}

