package com.snapshoes.store.service

import com.snapshoes.store.persistence.entities.User
import com.snapshoes.store.persistence.entities.UserRole
import com.snapshoes.store.persistence.repositories.UserRepository
import com.snapshoes.store.presentation.dtos.mappers.UserMapper
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper,
    private val encoder: PasswordEncoder
): UserDetailsService  {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
        return userMapper.mapToUserDetails(user)
    }

    fun saveUser(username: String, password: String) {
        val user = User(
            username = username,
            password = encoder.encode(password),
            role = UserRole.STORE.role
        )
        userRepository.save(user)
    }
}