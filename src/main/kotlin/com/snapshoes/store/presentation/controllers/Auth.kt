package com.snapshoes.store.presentation.controllers

import com.snapshoes.store.presentation.dtos.request.auth.AuthRequestDto
import com.snapshoes.store.presentation.dtos.request.auth.RefreshTokenRequestDto
import com.snapshoes.store.presentation.dtos.response.auth.AuthResponseDto
import com.snapshoes.store.presentation.dtos.response.auth.RefreshTokenResponseDto
import com.snapshoes.store.service.AuthService
import com.snapshoes.store.service.UserService
import jakarta.transaction.Transactional
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/auth")
class Auth(
    private val authService: AuthService,
    private val userService: UserService,
) {
    @Transactional
    @PostMapping("/login")
    fun authenticate(@RequestBody form: AuthRequestDto): ResponseEntity<AuthResponseDto> {
        val token = authService.authenticate(form)
        return ResponseEntity.ok(token)
    }

    @Transactional
    @PostMapping("/refresh")
    fun refreshToken(@RequestBody form: RefreshTokenRequestDto): ResponseEntity<RefreshTokenResponseDto> {
        val token = authService.refreshToken(form.refreshToken)
        return ResponseEntity.ok(RefreshTokenResponseDto(newAccessToken = token))
    }

    @Transactional
    @PostMapping("/create")
    fun create(
        @RequestBody form: AuthRequestDto,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AuthResponseDto> {
        userService.saveUser(username = form.username, password = form.password)
        val token = authService.authenticate(form)
        return ResponseEntity.ok(token)
    }
}