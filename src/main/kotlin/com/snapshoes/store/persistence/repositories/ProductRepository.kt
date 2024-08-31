package com.snapshoes.store.persistence.repositories
import com.snapshoes.store.persistence.entities.Product

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface ProductRepository: JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    fun findByBrandId(brandId: Long): List<Product>
    fun findByStoreId(storeId: Long): List<Product>
}