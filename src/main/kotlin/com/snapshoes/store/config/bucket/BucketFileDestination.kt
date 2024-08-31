package com.snapshoes.store.config.bucket

import com.snapshoes.store.persistence.entities.UserRole

data class BucketFileDestination(
    val role: UserRole,
    val userIdentifier: String,
    val path: String = getDefaultPath(role),
    val itemIdentifier: String? = "1"
){
    companion object {
        private fun getDefaultPath(role: UserRole): String {
            return when (role) {
                UserRole.ADMIN -> "profile"
                UserRole.USER -> "profile"
                UserRole.STORE -> "products"
            }
        }
    }
}


