package com.example.scoutkt.mainui.components.settings

import android.Manifest
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.scoutkt.R
import com.example.scoutkt.data.preferences.CurrentUser
import com.example.scoutkt.data.preferences.UserPreferences
import com.example.scoutkt.util.camera.rememberCameraLauncher
import com.example.scoutkt.util.permission.rememberPermission

@Composable
fun SettingsScreen(
    onLogoutClick: () -> Unit,
    innerPadding: PaddingValues,
    userPreferences: UserPreferences,
    currentUser: CurrentUser
) {
    var profileImageUri by remember { mutableStateOf<Uri?>(currentUser.getCurrentUser()
        ?.let { userPreferences.getImageUri(it) }) }
    var showDialog by remember { mutableStateOf(false) }
    var contentScale by remember { mutableStateOf(ContentScale.Crop) } // State for content scale
    val ctx = LocalContext.current

    val cameraLauncher = rememberCameraLauncher()

    val cameraPermission = rememberPermission(Manifest.permission.CAMERA) { status ->
        if (status.isGranted) {
            cameraLauncher.captureImage()
        } else {
            Toast.makeText(ctx, "Permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    fun takePicture() =
        if (cameraPermission.status.isGranted) {
            cameraLauncher.captureImage()
        } else {
            cameraPermission.launchPermissionRequest()
        }

    val launcherPickImage = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            profileImageUri = uri
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Seleziona Immagine Profilo") },
            text = { Text("Vuoi scattare una foto o scegliere dalla galleria?") },
            confirmButton = {
                TextButton(onClick = {
                    takePicture()
                }) {
                    Text("Scatta Foto")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    launcherPickImage.launch("image/*")
                    showDialog = false
                }) {
                    Text("Scegli dalla Galleria")
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        // Profile Image
        Box(
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
                .clickable { showDialog = true } // Show dialog on image click


        ) {

             if (profileImageUri != null) {
                AsyncImage(
                    ImageRequest.Builder(ctx)
                        .data(profileImageUri)
                        .crossfade(true)
                        .build(),
                    "Selected image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                currentUser.getCurrentUser()
                    ?.let { userPreferences.saveImage(it,profileImageUri.toString()) }
            }
             else {
                Image(
                    painter = painterResource(id = R.drawable.droid_head), // Placeholder image in your resources
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = contentScale // Set content scale
                )
            }
        }




        // Dark Theme Switch
        val value = isSystemInDarkTheme()
        var isDarkTheme by remember { mutableStateOf(value) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Tema Scuro", style = MaterialTheme.typography.bodyLarge)
            Switch(
                checked = isDarkTheme,
                onCheckedChange = { isDarkTheme = it }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Logout Button
        Button(
            onClick = onLogoutClick,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
                .size(100.dp) // Set the size of the button
        ) {
            Text(text = "Logout", color = Color.White)
        }
    }
}
