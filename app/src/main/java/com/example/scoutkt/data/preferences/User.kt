package com.example.scoutkt.data.preferences

data class User(
    val username: String,
    val email: String,
    val password: String,
    var profileImagePath: String? = null
)
