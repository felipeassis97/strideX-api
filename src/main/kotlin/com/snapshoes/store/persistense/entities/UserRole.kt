package com.snapshoes.store.persistense.entities

enum class UserRole(val role: String) {
    ADMIN(role = "ADMIN"),
    STORE(role = "STORE"),
    USER(role = "USER");

    override fun toString(): String {
        return this.role
    }

    companion object {
        fun fromRoleString(roleString: String): UserRole? {
            return entries.find { it.role == roleString }
        }
    }
}