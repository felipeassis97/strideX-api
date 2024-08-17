package com.snapshoes.store.persistense.repositories
import com.snapshoes.store.persistense.entities.Genre

import org.springframework.data.jpa.repository.JpaRepository

interface GenreRepository: JpaRepository<Genre, Long> {}