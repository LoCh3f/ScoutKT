package com.example.scoutkt.login
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.scoutkt.CryptoViewModel
import com.example.scoutkt.CryptoViewModelFactory
import com.example.scoutkt.data.preferences.UserPreferences
import com.example.scoutkt.MainActivity
import com.example.scoutkt.data.preferences.CurrentUser
import com.example.scoutkt.registration.RegistrationActivity
import com.example.scoutkt.mainui.theme.ScoutKTTheme

class LoginActivity : ComponentActivity() {
    private lateinit var userPreferences: UserPreferences
    private lateinit var currentUser: CurrentUser
    private lateinit var viewModel: CryptoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentUser = CurrentUser(context = this)
        if (currentUser.getCurrentUser() != null) {
            startActivity(Intent(this,MainActivity::class.java))
        }
        enableEdgeToEdge()
        userPreferences = UserPreferences(context = this)
        setContent {
            ScoutKTTheme {
                LoginPage(
                    userPreferences = userPreferences,
                    currentUser = currentUser,
                    onLoginSuccess = {
                        // Avvia MainActivity dopo il login
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    },
                    onRegisterClicked = {
                        val intent = Intent(this, RegistrationActivity::class.java)
                        startActivity(intent)
                    }
                )
            }

        }
    }

    override fun onStart() {
        super.onStart()
        viewModel = ViewModelProvider(
            this,
            CryptoViewModelFactory(application)
        )[CryptoViewModel::class.java]
        viewModel.refreshCryptos()
    }
}
