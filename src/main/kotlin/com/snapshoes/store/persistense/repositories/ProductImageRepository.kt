package com.snapshoes.store.persistense.repositories

import com.snapshoes.store.persistense.entities.ProductImage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ProductImageRepository : JpaRepository<ProductImage, Long> {
    @Query("SELECT pi FROM ProductImage pi WHERE pi.product.id = :productId")
    fun findImagesByProductId(@Param("productId") productId: Long): List<ProductImage>
}