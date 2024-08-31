package com.snapshoes.store.persistence.repositories
import com.snapshoes.store.persistence.entities.Brand

import org.springframework.data.jpa.repository.JpaRepository

interface BrandRepository: JpaRepository<Brand, Long> {}