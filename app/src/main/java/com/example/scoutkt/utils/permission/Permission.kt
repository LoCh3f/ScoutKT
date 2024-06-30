package com.example.scoutkt.utils.permission

enum class Permission {
    Unknown,
    Granted,
    Denied,
    PermanentlyDenied;
    val isGranted get() = this == Granted
    val isDenied get() =
        this == Denied ||
                this == PermanentlyDenied
}