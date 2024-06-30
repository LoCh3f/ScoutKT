package com.example.scoutkt.utils.permission

interface PermissionHandler {
    val permission: String
    val status: Permission
    fun launchPermissionRequest()
}