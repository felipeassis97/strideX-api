package com.snapshoes.store.presentation.controllers

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import com.snapshoes.store.service.AddressService
import org.springframework.web.util.UriComponentsBuilder
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.transaction.annotation.Transactional
import com.snapshoes.store.presentation.dtos.response.common.AddressDto
import com.snapshoes.store.presentation.dtos.request.store.SaveAddressDto

@RestController
@RequestMapping("/address")
class Address(
    private val service: AddressService
) {
    @PostMapping
    @Transactional
    fun save(
        @RequestBody @Valid form: SaveAddressDto,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AddressDto> {
        val address =  service.saveAddress(form)
        val uri = uriBuilder.path("/address/${address.id}").build().toUri()
        return ResponseEntity.created(uri).body(address)
    }
}