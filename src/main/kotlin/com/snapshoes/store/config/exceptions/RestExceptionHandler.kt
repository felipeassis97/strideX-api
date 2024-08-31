package com.snapshoes.store.config.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(NotFoundException::class)
    private fun notFoundHandler(e: NotFoundException): ResponseEntity<RestExceptionResponse> {
        val response = RestExceptionResponse(HttpStatus.NOT_FOUND.name, e.message ?: "Item not found!")
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response)
    }

    @ExceptionHandler(RefreshTokenException::class)
    private fun refreshTokenHandler(e: RefreshTokenException): ResponseEntity<RestExceptionResponse> {
        val response = RestExceptionResponse(HttpStatus.FORBIDDEN.name, e.message ?: "Item not found!")
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response)
    }

    @ExceptionHandler(RuntimeException::class)
    private fun genericHandler(e: RuntimeException): ResponseEntity<RestExceptionResponse> {
        val response = RestExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.name, e.message ?: "Item not found!")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response)
    }
}