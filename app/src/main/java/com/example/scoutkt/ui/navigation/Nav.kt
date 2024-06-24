package com.example.scoutkt.ui.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scoutkt.R
import com.example.scoutkt.data.preferences.CurrentUser
import com.example.scoutkt.data.preferences.MarketPreferences
import com.example.scoutkt.ui.components.ScaffoldLayout


@Composable
fun ComposeNavigation(currentUser: CurrentUser, marketPreferences: MarketPreferences) {
    val  navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home" ) {
        composable("Home") {
            ScaffoldLayout(activityName = "Home", id = R.drawable.baseline_home_24,navController,currentUser,marketPreferences)
        }
        composable("Favorites") {
            ScaffoldLayout(activityName = "Favorites", id = R.drawable.baseline_assistant_24,navController,currentUser,marketPreferences)
        }
        composable("Settings"){
            ScaffoldLayout(activityName = "Settings", id =R.drawable.baseline_app_settings_alt_24,navController, currentUser,marketPreferences)

        }

    }
}
