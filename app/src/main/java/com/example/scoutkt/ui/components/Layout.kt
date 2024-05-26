package com.example.scoutkt.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.scoutkt.ui.components.appheader.AppHeader

@Composable
fun ScaffoldLayout(activityName: String, @DrawableRes id: Int,navController: NavController) {
    Scaffold(modifier = Modifier,
             topBar = { AppHeader(activityName = activityName, id = id)},
             bottomBar = { SimpleNavigationBar(navController) }) {innerPadding ->
        ScrollingStock(innerPadding = innerPadding)


    }
}