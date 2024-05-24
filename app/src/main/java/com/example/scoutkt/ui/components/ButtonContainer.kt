package com.example.scoutkt.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun StockName(stockName: String) {
    Text(stockName)
}

@Composable
fun Percentage(value: Int) {
    Text("$value")
}

@Composable
fun Graph() {

}

@Composable
fun ContainerButton(value: Int,stockName: String) {
    Percentage(value)
    StockName(stockName)
}