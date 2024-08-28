package com.snapshoes.store.config.exceptions

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message) {
}

class TokenNotRefreshed(message: String?) : RuntimeException(message) {
}