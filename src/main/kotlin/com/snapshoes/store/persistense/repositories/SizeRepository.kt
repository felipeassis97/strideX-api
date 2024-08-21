package com.snapshoes.store.persistense.repositories

import com.snapshoes.store.persistense.entities.Size
import org.springframework.data.jpa.repository.JpaRepository

interface SizeRepository: JpaRepository<Size, Long> {}