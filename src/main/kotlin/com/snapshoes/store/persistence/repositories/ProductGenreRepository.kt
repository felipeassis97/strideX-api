package com.snapshoes.store.persistence.repositories

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import com.snapshoes.store.persistence.entities.ProductGenre
import org.springframework.data.jpa.repository.JpaRepository

interface ProductGenreRepository : JpaRepository<ProductGenre, Long> {
    @Query("SELECT pg FROM ProductGenre pg WHERE pg.product.id = :productId")
    fun findGenresByProductId(@Param("productId") productId: Long): List<ProductGenre>

    fun deleteByGenreId(genreId: Long)
    fun deleteByProductId(productId: Long)
}