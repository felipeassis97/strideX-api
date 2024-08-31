package com.snapshoes.store.persistence.repositories
import com.snapshoes.store.persistence.entities.Genre

import org.springframework.data.jpa.repository.JpaRepository

interface GenreRepository: JpaRepository<Genre, Long> {}