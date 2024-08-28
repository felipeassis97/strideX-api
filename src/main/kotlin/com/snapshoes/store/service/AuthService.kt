package com.snapshoes.store.service

import com.snapshoes.store.config.security.JwtProperties
import com.snapshoes.store.presentation.dtos.request.auth.AuthRequestDto
import com.snapshoes.store.presentation.dtos.response.auth.AuthResponseDto
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthService(
    private val userService: UserService,
    private val tokenService: TokenService,
    private val authenticationManager: AuthenticationManager,
    private val jwtProperties: JwtProperties
) {
    fun authenticate(form: AuthRequestDto): AuthResponseDto {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                form.username, form.password
            )
        )

        val user = userService.loadUserByUsername(form.username)
        val accessToken =
            tokenService.generateToken(
                userDetails = user,
                expirationDate = Date(System.currentTimeMillis() + jwtProperties.accessTokenExpiration)
            )

        return AuthResponseDto(accessToken)
    }
}