package com.snapshoes.store.persistense.repositories
import com.snapshoes.store.persistense.entities.Store
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepository: JpaRepository<Store, Long> {}

