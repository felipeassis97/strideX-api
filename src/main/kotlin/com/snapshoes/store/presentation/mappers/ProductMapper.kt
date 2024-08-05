package com.snapshoes.store.presentation.mappers

import Mapper
import org.springframework.stereotype.Component
import com.snapshoes.store.persistense.entities.Product
import com.snapshoes.store.presentation.dtos.ProductDto


@Component
class ProductMapper(
//    private val brandMapper: BrandMapper,
//    private val productImageMapper: ProductImageMapper,
//    private val productSizeMapper: ProductSizeMapper,
//    private val productGenreMapper: ProductGenreMapper
) : Mapper<Product, ProductDto> {
    override fun map(t: Product): ProductDto {

        val brandMapper= BrandMapper();
        val productImageMapper =ProductImageMapper();
        val productGenreMapper= ProductGenreMapper();
        val productSizeMapper= ProductSizeMapper();
        return ProductDto(
            id = t.id,
            title = t.title,
            description = t.description,
            price = t.price,
            quantity = t.quantity,
            storeId = t.storeId,
            brand = brandMapper.map(t.brand),
            images = t.images.map { productImageMapper.map(it) },
            productSizes = t.productSizes.map { productSizeMapper.map(it) },
            productGenres = t.productGenres.map { productGenreMapper.map(it) }
        )
    }
}
