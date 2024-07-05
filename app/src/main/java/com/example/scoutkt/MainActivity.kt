package com.example.scoutkt

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.scoutkt.data.preferences.CurrentUser
import com.example.scoutkt.data.preferences.MarketPreferences
import com.example.scoutkt.data.preferences.UserPreferences
import com.example.scoutkt.login.LoginActivity
import com.example.scoutkt.mainui.navigation.ComposeNavigation

import com.example.scoutkt.mainui.theme.ScoutKTTheme
import com.tradingview.lightweightcharts.view.ChartsView

class MainActivity : ComponentActivity() {
    private lateinit var currentUser: CurrentUser
    private lateinit var marketPreferences: MarketPreferences
    private lateinit var userPreferences: UserPreferences
    private lateinit var viewModel: CryptoViewModel
    private lateinit var chartsView: ChartsView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentUser = CurrentUser(context = this)
        marketPreferences = MarketPreferences(context = this)
        userPreferences = UserPreferences(context = this)
        viewModel = ViewModelProvider(this, CryptoViewModelFactory(application)).get(CryptoViewModel::class.java)
        viewModel.refreshCryptos()
        //viewModel.refreshHistory("BTC")
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
    }
}



