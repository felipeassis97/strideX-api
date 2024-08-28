package com.snapshoes.store.service

import com.snapshoes.store.config.exceptions.TokenNotRefreshed
import com.snapshoes.store.config.security.JwtProperties
import com.snapshoes.store.persistense.repositories.RefreshTokenRepository
import com.snapshoes.store.presentation.dtos.request.auth.AuthRequestDto
import com.snapshoes.store.presentation.dtos.request.auth.RefreshTokenRequestDto
import com.snapshoes.store.presentation.dtos.response.auth.AuthResponseDto
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthService(
    private val userService: UserService,
    private val tokenService: TokenService,
    private val authenticationManager: AuthenticationManager,
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository,
) {
    fun authenticate(form: AuthRequestDto): AuthResponseDto {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                form.username, form.password
            )
        )

        val user = userService.loadUserByUsername(form.username)
        val accessToken = generateAccessToken(user)
        val refreshToken = generateRefreshToken(user)

        refreshTokenRepository.save(refreshToken, user)

        return AuthResponseDto(accessToken, refreshToken)
    }

    private fun generateAccessToken(user: UserDetails) = tokenService.generateToken(
        userDetails = user,
        expirationDate = Date(System.currentTimeMillis() + jwtProperties.accessTokenExpiration)
    )

    private fun generateRefreshToken(user: UserDetails) = tokenService.generateToken(
        userDetails = user,
        expirationDate = Date(System.currentTimeMillis() + jwtProperties.refreshTokenExpiration)
    )

    fun refreshToken(token: String): String? {
        val extractEmail = tokenService.extractEmail(token)
        return extractEmail?.let { email ->
            val currentUserDetails = userService.loadUserByUsername(email)
            val refreshTokenUser = refreshTokenRepository.findUserDetailsByToken(token)

            if (!tokenService.isExpired(token) && currentUserDetails.username == refreshTokenUser?.username)
                generateAccessToken(currentUserDetails)
            else
                throw TokenNotRefreshed("Error while refreshing token")
        }
    }
}