package com.snapshoes.store.persistense.repositories

import com.snapshoes.store.persistense.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(email: String) : User
}