package com.example.scoutkt.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scoutkt.R
import com.example.scoutkt.ui.components.ScaffoldLayout


@Composable
fun ComposeNavigation() {
    val  navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home" ) {
        composable("Home") {
            ScaffoldLayout(activityName = "Home", id = R.drawable.baseline_home_24,navController)
        }
        composable("Favorites") {
            ScaffoldLayout(activityName = "Favorites", id = R.drawable.baseline_assistant_24,navController)
        }
        composable("Alarms") {
            ScaffoldLayout(activityName = "Alarms", id = R.drawable.baseline_alarm_24,navController)
        }
        composable("Settings"){
            ScaffoldLayout(activityName = "Settings", id =R.drawable.baseline_app_settings_alt_24,navController )

        }

    }
}
