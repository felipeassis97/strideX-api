package com.snapshoes.store.presentation.dtos.mappers

import com.snapshoes.store.config.interfaces.Mapper
import com.snapshoes.store.persistence.entities.User
import com.snapshoes.store.persistence.entities.UserRole
import com.snapshoes.store.presentation.dtos.request.UserDto
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

typealias UserCore = org.springframework.security.core.userdetails.User

@Component
class UserMapper : Mapper<User, UserDto> {
    override fun toDto(entity: User): UserDto {
        return UserDto(
            id = entity.id,
            username = entity.username,
            password = entity.password,
            role = UserRole.fromRoleString(entity.role)
        )
    }

    override fun toEntity(dto: UserDto): User {
        return User(
            id = dto.id,
            username = dto.username,
            password = dto.password,
            role = dto.role.toString()
        )
    }

    fun mapToUserDetails(user: User): UserDetails {
       return  UserCore.builder()
            .username(user.username)
            .password(user.password)
            .roles(user.role)
            .build()
    }
}