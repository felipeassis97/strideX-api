package com.snapshoes.store.persistence.repositories

import com.snapshoes.store.persistence.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(email: String) : User
}