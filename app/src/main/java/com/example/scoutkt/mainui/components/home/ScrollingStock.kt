package com.example.scoutkt.mainui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.scoutkt.mainui.components.StockCard

@Composable
fun ScrollingStock(innerPadding: PaddingValues) {
    LazyColumn (modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
        .fillMaxSize()
        .padding(innerPadding), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(10.dp)
    ) {
        item {
            val per = -2.13f
            (1..20).forEach{
                StockCard(per, onHeartClick = {})
            }
        }

    }
}