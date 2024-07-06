package com.example.scoutkt.mainui.components.appheader

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHeader(activityName: String,@DrawableRes id: Int) {
    TopAppBar(title = { Text(activityName, textAlign = TextAlign.Center) },
        modifier = Modifier.padding(10.dp),
        navigationIcon = { Image(painter = painterResource(id), contentDescription = "",
            alignment = Alignment.Center
        )
        }
    )
}