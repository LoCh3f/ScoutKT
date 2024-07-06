package com.example.scoutkt.mainui.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.scoutkt.CryptoViewModel
import com.example.scoutkt.R
import com.example.scoutkt.data.preferences.CurrentUser
import com.example.scoutkt.data.preferences.MarketPreferences
import com.example.scoutkt.data.preferences.UserPreferences
import com.example.scoutkt.mainui.components.appheader.AppHeader
import com.example.scoutkt.mainui.components.bottomappbar.SimpleNavigationBar
import com.example.scoutkt.mainui.components.home.scroll.ScrollingStock
import com.example.scoutkt.mainui.components.settings.SettingsScreen

@Composable
fun ScaffoldLayout(activityName: String, @DrawableRes id: Int,navController: NavController,currentUser: CurrentUser,marketPreferences: MarketPreferences, userPreferences: UserPreferences, onLogOutClick: () -> Unit,viewModel: CryptoViewModel) {
    if (id == R.drawable.baseline_home_24) {
        Scaffold(modifier = Modifier,
            topBar = { AppHeader(activityName = activityName, id = id)},
            bottomBar = { SimpleNavigationBar(navController) }
        )
            {innerPadding ->
                ScrollingStock(innerPadding = innerPadding,viewModel)
            }
    }
    else if (id == R.drawable.baseline_app_settings_alt_24) {
        Scaffold(modifier = Modifier,
            topBar = { AppHeader(activityName = activityName, id = id)},
            bottomBar = { SimpleNavigationBar(navController) }
        )
        { innerPadding ->
            SettingsScreen (onLogOutClick,innerPadding,userPreferences,currentUser)
        }
    }
    else if (id == R.drawable.baseline_assistant_24) {
        Scaffold(modifier = Modifier,
            topBar = { AppHeader(activityName = activityName, id = id)},
            bottomBar = { SimpleNavigationBar(navController) }
        )
        {innerPadding ->
            ScrollingStock(innerPadding = innerPadding,viewModel)
        }
    }

}