package com.example.scoutkt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.scoutkt.data.preferences.CurrentUser
import com.example.scoutkt.data.preferences.MarketPreferences
import com.example.scoutkt.ui.navigation.ComposeNavigation

import com.example.scoutkt.ui.theme.ScoutKTTheme

class MainActivity : ComponentActivity() {
    private lateinit var currentUser: CurrentUser
    private lateinit var marketPreferences: MarketPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentUser = CurrentUser(context = this)
        marketPreferences = MarketPreferences(context = this)
        enableEdgeToEdge()
        setContent {
            ScoutKTTheme {
                ComposeNavigation(currentUser,marketPreferences)
            }
        }
    }
}



