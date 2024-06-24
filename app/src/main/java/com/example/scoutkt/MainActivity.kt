package com.example.scoutkt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.scoutkt.ui.navigation.ComposeNavigation

import com.example.scoutkt.ui.theme.ScoutKTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScoutKTTheme {
                ComposeNavigation()
            }
        }
    }
}



