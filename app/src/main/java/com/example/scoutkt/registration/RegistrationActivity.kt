package com.example.scoutkt.registration
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.scoutkt.MainActivity
import com.example.scoutkt.data.preferences.CurrentUser
import com.example.scoutkt.data.preferences.UserPreferences
import com.example.scoutkt.ui.theme.ScoutKTTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

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




