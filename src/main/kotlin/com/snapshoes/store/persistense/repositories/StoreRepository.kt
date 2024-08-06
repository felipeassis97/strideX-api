package com.snapshoes.store.persistense.repositories
import com.snapshoes.store.persistense.entities.Store
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Page

interface StoreRepository: JpaRepository<Store, Long> {
    fun findByName(name: String, pageable: Pageable): Page<Store>
}

