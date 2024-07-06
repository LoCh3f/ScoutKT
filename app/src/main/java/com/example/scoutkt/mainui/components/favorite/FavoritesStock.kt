package com.example.scoutkt.mainui.components.favorite

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.scoutkt.CryptoViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.scoutkt.data.preferences.CurrentUser
import com.example.scoutkt.data.preferences.MarketPreferences
import com.example.scoutkt.mainui.components.home.card.StockCard

@Composable
fun FavoritesStock(
    innerPadding: PaddingValues,
    viewModel: CryptoViewModel,
    currentUser: CurrentUser,
    marketPreferences: MarketPreferences,
) {
    val cryptoList = viewModel.cryptos.observeAsState(initial = emptyList()).value
    val history = viewModel.history.observeAsState(initial = emptyList()).value
    val favorites by remember {
        mutableStateOf(currentUser.getCurrentUser()?.let { marketPreferences.getFavourites(it) })
    }
    LazyColumn(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(16.dp)
    ) {
        items(cryptoList) { crypto ->
            if (currentUser.getCurrentUser()?.let
                { marketPreferences.isFavourite(it,crypto.symbol) } == true) {
                StockCard(cryptoEntity = crypto, history, selected = true) {
                    marketPreferences.removeFavourite(currentUser.getCurrentUser()!!, crypto.symbol)

                }
            }
        }
    }
}


