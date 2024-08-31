package com.snapshoes.store.persistence.repositories

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.jpa.repository.Modifying
import com.snapshoes.store.persistence.entities.ProductImage
import org.springframework.data.jpa.repository.JpaRepository

interface ProductImageRepository : JpaRepository<ProductImage, Long> {
    @Query("SELECT pi FROM ProductImage pi WHERE pi.product.id = :productId")
    fun findImagesByProductId(@Param("productId") productId: Long): List<ProductImage>

    @Modifying
    @Query("UPDATE ProductImage pi SET pi.url = :url WHERE pi.id = :imageId")
    fun updateImageUrl(@Param("imageId") imageId: Long, @Param("url") url: String): Int

    fun deleteByProductId(productId: Long)
}