package com.example.scoutkt.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

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
fun ContainerButton(value: Int,stockName: String) {
    StockPercentage(value)
    StockName(stockName)
}