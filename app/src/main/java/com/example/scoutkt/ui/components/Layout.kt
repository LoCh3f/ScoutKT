package com.example.scoutkt.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ScaffoldLayout(activityName: String, @DrawableRes id: Int) {
    Scaffold(modifier = Modifier,
             topBar = { AppHeader(activityName = activityName, id = id)},
             bottomBar = { SimpleNavigationBar() }) {innerPadding ->
        ScrollingStock(innerPadding = innerPadding)


    }
}