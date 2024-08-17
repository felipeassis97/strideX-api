package com.snapshoes.store.persistense.repositories
import com.snapshoes.store.persistense.entities.Address

import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository: JpaRepository<Address, Long> {}