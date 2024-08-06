package com.snapshoes.store.persistense.repositories
import com.snapshoes.store.persistense.entities.Brand

import org.springframework.data.jpa.repository.JpaRepository

interface BrandRepository: JpaRepository<Brand, Long> {}