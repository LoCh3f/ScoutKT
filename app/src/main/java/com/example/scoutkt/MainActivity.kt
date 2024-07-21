package com.example.scoutkt

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.scoutkt.data.preferences.CurrentUser
import com.example.scoutkt.data.preferences.MarketPreferences
import com.example.scoutkt.data.preferences.UserPreferences
import com.example.scoutkt.login.LoginActivity
import com.example.scoutkt.mainui.navigation.ComposeNavigation

import com.example.scoutkt.mainui.theme.ScoutKTTheme
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    private lateinit var currentUser: CurrentUser
    private lateinit var marketPreferences: MarketPreferences
    private lateinit var userPreferences: UserPreferences
    private lateinit var viewModel: CryptoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentUser = CurrentUser(context = this)
        marketPreferences = MarketPreferences(context = this)
        userPreferences = UserPreferences(context = this)
        viewModel = ViewModelProvider(this, CryptoViewModelFactory(application)).get(CryptoViewModel::class.java)
        enableEdgeToEdge()
        setContent {
            ScoutKTTheme {
                ComposeNavigation(currentUser,marketPreferences,userPreferences,
                    onLogOutClick = {
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        currentUser.setCurrentUser()
                    },
                    viewModel
                )
            }
        }
        scheduleCryptoUpdates()
    }
    private fun scheduleCryptoUpdates() {
        val workRequest: WorkRequest = PeriodicWorkRequestBuilder<CryptoUpdateWorker>(1, TimeUnit.HOURS)
            .build()

        WorkManager.getInstance(this).enqueue(workRequest)
    }

    override fun onStart() {
        super.onStart()
        viewModel.refreshCryptos()
    }
}



