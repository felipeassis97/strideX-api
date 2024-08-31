package com.snapshoes.store.config.exceptions


class NotFoundException(message: String?) : RuntimeException(message) {
}

class RefreshTokenException(message: String?) : RuntimeException(message) {
}