package com.snapshoes.store.persistense.repositories


import com.snapshoes.store.persistense.entities.ProductGenre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ProductGenreRepository : JpaRepository<ProductGenre, Long> {
    @Query("SELECT pg FROM ProductGenre pg WHERE pg.product.id = :productId")
    fun findGenresByProductId(@Param("productId") productId: Long): List<ProductGenre>

    @Query("DELETE FROM ProductGenre pg WHERE pg.genre.id = :genreId")
    fun deleteByGenreId(@Param("genreId") genreId: Long)
}