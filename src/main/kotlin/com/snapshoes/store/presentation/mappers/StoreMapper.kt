package com.snapshoes.store.presentation.mappers

import Mapper
import org.springframework.stereotype.Component
import com.snapshoes.store.presentation.dtos.*
import com.snapshoes.store.persistense.entities.*


@Component
class StoreMapper: Mapper<Store, StoreDto> {
    override fun map(t: Store): StoreDto {
        val productMapper = ProductMapper();
        return StoreDto(
            id = t.id,
            name = t.name,
            description = t.description,
            logo = t.logo,
            address = AddressMapper().map(t.address),
            products = t.products.map { prod ->
                productMapper.map(prod)
            }
        )
    }
}
