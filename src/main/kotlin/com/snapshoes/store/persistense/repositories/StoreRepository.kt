package com.snapshoes.store.persistense.repositories
import com.snapshoes.store.persistense.entities.Store

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository



interface StoreRepository: JpaRepository<Store, Long> {
    fun findByName(name: String, pageable: Pageable): Page<Store>
}

