package com.example.scoutkt.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StockName(stockName: String) {
    Text(stockName)
}

@Composable
fun StockPercentage(value: Int) {
    Text("$value")
}

@Composable
fun StockGraph() {

}

@Composable
fun ButtonContainer(value: Int,stockName: String) {
    Row {
    StockPercentage(value)
    StockName(stockName)
    }
}