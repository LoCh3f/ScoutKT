package com.example.scoutkt.registration
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModel
import com.example.scoutkt.MainActivity
import com.example.scoutkt.data.preferences.UserPreferences

class RegistrationActivity : ComponentActivity() {
    lateinit var userPreferences: UserPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userPreferences = UserPreferences(context = this)
        setContent {
            RegistrationScreen(userPreferences, OnRegister = {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            })
        }
    }
}



class RegistrationViewModel : ViewModel() {
    fun saveUser(context: Context, username: String, email: String, password: String) {
        val userPreferences = UserPreferences(context)
        userPreferences.saveUser(username, email, password)
    }
}
