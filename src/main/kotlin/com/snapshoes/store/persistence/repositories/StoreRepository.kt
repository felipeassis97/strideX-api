package com.snapshoes.store.persistence.repositories
import com.snapshoes.store.persistence.entities.Store

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepository: JpaRepository<Store, Long> {
    fun findByName(name: String, pageable: Pageable): Page<Store>
}

