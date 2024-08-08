package com.snapshoes.store.presentation.dtos.mappers.common

interface Mapper<T, U> {
    fun map(t: T): U
}
