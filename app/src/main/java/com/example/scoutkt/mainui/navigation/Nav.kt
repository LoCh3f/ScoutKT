package com.example.scoutkt.mainui.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scoutkt.CryptoViewModel
import com.example.scoutkt.R
import com.example.scoutkt.data.preferences.CurrentUser
import com.example.scoutkt.data.preferences.MarketPreferences
import com.example.scoutkt.data.preferences.UserPreferences


@Composable
fun ComposeNavigation(currentUser: CurrentUser, marketPreferences: MarketPreferences, userPreferences: UserPreferences,onLogOutClick: () -> Unit, viewModel: CryptoViewModel) {
    val  navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HOME" ) {
        composable("Home") {
            ScaffoldLayout(activityName = "HOME", id = R.drawable.baseline_home_24,navController,currentUser, marketPreferences, userPreferences, onLogOutClick,viewModel)
        }
        composable("Favorites") {
            ScaffoldLayout(activityName = "FAVORITES", id = R.drawable.baseline_assistant_24,navController,currentUser, marketPreferences, userPreferences, onLogOutClick,viewModel)
        }
        composable("Settings"){
            ScaffoldLayout(activityName = "SETTINGS", id =R.drawable.baseline_app_settings_alt_24,navController, currentUser, marketPreferences, userPreferences, onLogOutClick,viewModel)

        }

    }
}
