package com.example.scoutkt.registration
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.scoutkt.MainActivity
import com.example.scoutkt.data.preferences.UserPreferences
import com.example.scoutkt.ui.theme.ScoutKTTheme

class RegistrationActivity : ComponentActivity() {
    lateinit var userPreferences: UserPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userPreferences = UserPreferences(context = this)
        setContent {
            ScoutKTTheme {
                RegistrationScreen(userPreferences, OnRegister = {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                })
            }

        }
    }
}




