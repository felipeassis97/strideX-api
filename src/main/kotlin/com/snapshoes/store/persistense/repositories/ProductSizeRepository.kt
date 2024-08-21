package com.snapshoes.store.persistense.repositories

import com.snapshoes.store.persistense.entities.ProductSize
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ProductSizeRepository : JpaRepository<ProductSize, Long> {
    @Query("SELECT pg FROM ProductSize pg WHERE pg.product.id = :productId")
    fun findSizesByProductId(@Param("productId") productId: Long): List<ProductSize>
     fun deleteByProductId(productId: Long)
}