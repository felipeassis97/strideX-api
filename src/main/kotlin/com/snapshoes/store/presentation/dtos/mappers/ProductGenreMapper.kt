package com.snapshoes.store.presentation.dtos.mappers

import com.snapshoes.store.config.interfaces.Mapper
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Component
import com.snapshoes.store.persistense.entities.Product
import com.snapshoes.store.persistense.entities.ProductGenre
import com.snapshoes.store.presentation.dtos.response.common.GenreDto
import com.snapshoes.store.presentation.dtos.response.product.ProductGenreDto

@Component
class ProductGenreMapper(
    private val genreMapper: GenreMapper,
    private val entityManager: EntityManager
) : Mapper<ProductGenre, ProductGenreDto> {

    override fun toDto(entity: ProductGenre): ProductGenreDto {
        return ProductGenreDto(
            productId = entity.product.id,
            genre = genreMapper.toDto(entity.genre),
        )
    }

    override fun toEntity(dto: ProductGenreDto): ProductGenre {
        val productGenreRef = entityManager.getReference(Product::class.java, dto.productId)
        return ProductGenre(
            product = productGenreRef,
            genre = genreMapper.toEntity(dto.genre),
            createdAt = null,
            updatedAt = null
        )
    }

    fun genreDtoToEntity(dto: GenreDto, productId: Long?): ProductGenre {
        val productGenreRef = entityManager.getReference(Product::class.java, productId)

        return ProductGenre(
            product = productGenreRef,
            genre = genreMapper.toEntity(dto)
        )
    }
}