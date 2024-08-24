package com.snapshoes.store.service

import org.springframework.stereotype.Service
import com.snapshoes.store.presentation.dtos.mappers.SizeMapper
import com.snapshoes.store.persistense.repositories.SizeRepository
import com.snapshoes.store.presentation.dtos.request.common.CreateSizeDto
import com.snapshoes.store.presentation.dtos.response.common.SizeDto

@Service
class SizeService(
    private val sizeMapper: SizeMapper,
    private val sizeRepository: SizeRepository
) {
    fun fetchAllSizes(): List<SizeDto> {
        val sizes = sizeRepository.findAll()
        return sizes.map {
            sizeMapper.toDto(it)
        }
    }

    fun createSize(form: CreateSizeDto): SizeDto {
        val sizeEntity = sizeMapper.createSizeDtoToEntity(form)
        val size = sizeRepository.save(sizeEntity)
        return sizeMapper.toDto(size)
    }
}