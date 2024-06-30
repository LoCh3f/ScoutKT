package com.example.scoutkt.util.permission

interface PermissionHandler {
    val permission: String
    val status: Permission
    fun launchPermissionRequest()
}