package com.snapshoes.store.persistense.repositories

import com.snapshoes.store.persistense.entities.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {}