package com.example.scoutkt.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.scoutkt.R
import com.example.scoutkt.ui.components.appheader.AppHeader
import com.example.scoutkt.ui.components.bottomappbar.SimpleNavigationBar
import com.example.scoutkt.ui.components.home.ScrollingStock
import com.example.scoutkt.ui.components.settings.SettingsScreen

@Composable
fun ScaffoldLayout(activityName: String, @DrawableRes id: Int,navController: NavController) {
    if (id == R.drawable.baseline_home_24) {
        Scaffold(modifier = Modifier,
            topBar = { AppHeader(activityName = activityName, id = id)},
            bottomBar = { SimpleNavigationBar(navController) }
        )
            {innerPadding ->
                ScrollingStock(innerPadding = innerPadding)
            }
    }
    else if (id == R.drawable.baseline_app_settings_alt_24) {
        Scaffold(modifier = Modifier,
            topBar = { AppHeader(activityName = activityName, id = id)},
            bottomBar = { SimpleNavigationBar(navController) }
        )
        { innerPadding ->
            SettingsScreen (onLogoutClick = {},innerPadding)
        }
    }
    else if (id == R.drawable.baseline_assistant_24) {
        Scaffold(modifier = Modifier,
            topBar = { AppHeader(activityName = activityName, id = id)},
            bottomBar = { SimpleNavigationBar(navController) }
        )
        { innerPadding ->
            SettingsScreen (onLogoutClick = {},innerPadding)
        }

    }

}