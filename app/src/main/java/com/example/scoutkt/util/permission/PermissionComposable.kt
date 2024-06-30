package com.example.scoutkt.util.permission

import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

@Composable
fun rememberPermission(
    permission: String,
    onResult: (status: Permission) -> Unit = {}
): PermissionHandler {
    var status by remember { mutableStateOf(Permission.Unknown) }
    val activity = (LocalContext.current as ComponentActivity)
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        status = when {
            isGranted -> Permission.Granted
            activity.shouldShowRequestPermissionRationale(permission) -> Permission.Denied
            else -> Permission.PermanentlyDenied
        }
        onResult(status)
    }
    val permissionHandler by remember {
        derivedStateOf {
            object : PermissionHandler {
                override val permission = permission
                override val status = status
                override fun launchPermissionRequest() = permissionLauncher.launch(permission)
            }
        }
    }
    return permissionHandler
}