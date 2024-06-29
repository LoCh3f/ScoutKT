package com.example.scoutkt.mainui.components.settings

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.scoutkt.R

@Composable
fun SettingsScreen(
    onLogoutClick: () -> Unit,
    innerPadding: PaddingValues
) {
    var profileImageUri by remember { mutableStateOf<Uri?>(null) }

    // Usiamo rememberImagePainter solo quando profileImageUri non è null
    val painter = if (profileImageUri != null) rememberAsyncImagePainter(profileImageUri!!) else null

    val launcherTakePicture = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        if (bitmap != null) {
            // Handle the taken picture (Bitmap)
            profileImageUri = null // Resetting to null to signify a direct Bitmap, not Uri.
        }
    }

    val launcherPickImage = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            profileImageUri = uri
        }
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
        ) {
            if (profileImageUri != null) {
                Image(
                    painter = painter!!,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.droid_head), // Placeholder image in your resources
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // Profile Image Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                launcherTakePicture.launch(null)
            }) {
                Text("Scatta Foto")
            }
            Button(onClick = {
                launcherPickImage.launch("image/*")
            }) {
                Text("Scegli dalla Galleria")
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
                .padding(top = 16.dp),
        ) {
            Text(text = "Logout", color = Color.White)
        }
    }
}
