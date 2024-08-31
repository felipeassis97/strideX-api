package com.snapshoes.store.persistence.repositories
import com.snapshoes.store.persistence.entities.Address

import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository: JpaRepository<Address, Long> {}