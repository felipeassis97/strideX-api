package com.snapshoes.store.service

import com.snapshoes.store.config.security.JwtProperties
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.security.Key
import java.util.Date
import java.util.Base64

@Service
class TokenService(
    private val jwtProperties: JwtProperties
) {

    fun getKey(): Key =
        Keys.hmacShaKeyFor(
            jwtProperties.secret.toByteArray()
        )

    fun generateToken(
        userDetails: UserDetails,
        expirationDate: Date,
        additionalClaims: Map<String, Any> = emptyMap()
    ): String {
        return Jwts.builder()
            .claims()
            .subject(userDetails.username)
            .issuedAt(Date(System.currentTimeMillis()))
            .expiration(expirationDate)
            .add(additionalClaims)
            .and()
            .signWith(getKey())
            .compact()
    }

    fun isExpired(token: String): Boolean {
        return getAllClaims(token)
            .expiration
            .before(Date(System.currentTimeMillis()))
    }

    fun extractEmail(token: String): String? {
        return getAllClaims(token)
            .subject
    }



    fun isValid(token: String, userDetails: UserDetails): Boolean {
        val email = extractEmail(token)

        return userDetails.username == email && !isExpired(token)
    }


    private fun getAllClaims(token: String): Claims {
        val secretKey = Keys.hmacShaKeyFor(
            jwtProperties.secret.toByteArray()
        )
        val parser = Jwts.parser()
            .verifyWith(secretKey)
            .build()

        return parser.parseSignedClaims(token).payload
    }
}