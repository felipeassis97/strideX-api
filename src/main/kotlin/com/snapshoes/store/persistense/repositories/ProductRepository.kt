package com.snapshoes.store.persistense.repositories
import com.snapshoes.store.persistense.entities.Product

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface ProductRepository: JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    fun findByBrandId(brandId: Long): List<Product>
    fun findByStoreId(storeId: Long): List<Product>
}