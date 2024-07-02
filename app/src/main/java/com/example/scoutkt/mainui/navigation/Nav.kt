package com.example.scoutkt.mainui.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scoutkt.R
import com.example.scoutkt.data.preferences.CurrentUser
import com.example.scoutkt.data.preferences.MarketPreferences
import com.example.scoutkt.data.preferences.UserPreferences
import com.example.scoutkt.mainui.components.ScaffoldLayout


@Composable
fun ComposeNavigation(currentUser: CurrentUser, marketPreferences: MarketPreferences, userPreferences: UserPreferences) {
    val  navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home" ) {
        composable("Home") {
            ScaffoldLayout(activityName = "Home", id = R.drawable.baseline_home_24,navController,currentUser, marketPreferences, userPreferences)
        }
        composable("Favorites") {
            ScaffoldLayout(activityName = "Favorites", id = R.drawable.baseline_assistant_24,navController,currentUser, marketPreferences, userPreferences)
        }
        composable("Settings"){
            ScaffoldLayout(activityName = "Settings", id =R.drawable.baseline_app_settings_alt_24,navController, currentUser, marketPreferences, userPreferences)

        }

    }
}
