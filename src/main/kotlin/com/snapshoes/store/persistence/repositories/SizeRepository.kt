package com.snapshoes.store.persistence.repositories

import com.snapshoes.store.persistence.entities.Size
import org.springframework.data.jpa.repository.JpaRepository

interface SizeRepository: JpaRepository<Size, Long> {}