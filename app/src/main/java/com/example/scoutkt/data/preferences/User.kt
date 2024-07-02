package com.example.scoutkt.data.preferences

data class User(
    val username: String,
    val email: String,
    val password: String,
    val profileImagePath: String? = null
)
