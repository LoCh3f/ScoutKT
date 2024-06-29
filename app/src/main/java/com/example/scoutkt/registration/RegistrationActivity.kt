package com.example.scoutkt.registration
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.scoutkt.MainActivity
import com.example.scoutkt.data.preferences.CurrentUser
import com.example.scoutkt.data.preferences.UserPreferences
import com.example.scoutkt.mainui.theme.ScoutKTTheme

class RegistrationActivity : ComponentActivity() {
    private lateinit var userPreferences: UserPreferences
    private lateinit var currentUser: CurrentUser
   // private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       userPreferences = UserPreferences(context = this)
       currentUser = CurrentUser(context = this)
        setContent {
            ScoutKTTheme {
                RegistrationScreen(userPreferences, currentUser,
                    onRegister = {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                })
            }

        }
    }



}




