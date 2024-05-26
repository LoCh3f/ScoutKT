package com.example.scoutkt.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScrollingStock(innerPadding: PaddingValues) {
    LazyColumn (modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(10.dp)
    ) {
        item {
            (1..20).forEach{
                StockCard()
            }
        }

    }
}