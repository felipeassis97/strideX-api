package com.snapshoes.store.config.interfaces

interface Mapper<T, U> {
    fun toDto(entity: T): U
    fun toEntity(dto: U): T
}