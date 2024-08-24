package com.snapshoes.store.service

import org.springframework.stereotype.Service
import org.springframework.cache.annotation.Cacheable
import org.springframework.cache.annotation.CacheEvict
import com.snapshoes.store.config.exceptions.NotFoundException
import com.snapshoes.store.presentation.dtos.mappers.SizeMapper
import com.snapshoes.store.persistense.repositories.SizeRepository
import com.snapshoes.store.presentation.dtos.response.common.SizeDto
import com.snapshoes.store.presentation.dtos.request.common.CreateSizeDto

@Service
class SizeService(
    private val sizeMapper: SizeMapper,
    private val sizeRepository: SizeRepository
) {
    @Cacheable(cacheNames = ["Sizes"], key = "#root.method.name")
    fun fetchAllSizes(): List<SizeDto> {
        val sizes = sizeRepository.findAll()
        return sizes.map {
            sizeMapper.toDto(it)
        }
    }

    @CacheEvict(cacheNames = ["Sizes"], allEntries = true)
    fun createSize(form: CreateSizeDto): SizeDto {
        val sizeEntity = sizeMapper.createSizeDtoToEntity(form)
        val size = sizeRepository.save(sizeEntity)
        return sizeMapper.toDto(size)
    }

    @CacheEvict(cacheNames = ["Sizes"], allEntries = true)
    fun deleteSizeById(id: Long) {
        val size = sizeRepository.findById(id).orElseThrow {
            NotFoundException("Size not found with ID: $id")
        }
        sizeRepository.delete(size)
    }
}