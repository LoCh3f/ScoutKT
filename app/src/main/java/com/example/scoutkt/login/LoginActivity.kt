package com.example.scoutkt.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.scoutkt.MainActivity
import com.example.scoutkt.R
import com.example.scoutkt.ui.theme.ScoutKTTheme
import java.lang.reflect.Modifier


@SuppressLint("RestrictedApi")
class LoginActivity: ComponentActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           ScoutKTTheme {
               Surface(
                   color = MaterialTheme.colorScheme.background
               ) {
                   LoginPage(onLoginClicked = {
                       // Start HomeActivity on login button click
                       val intent = Intent(this, MainActivity::class.java)
                       startActivity(intent)
                   })
               }
           }
        }
    }
}
