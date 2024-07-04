package com.example.scoutkt.data.remote

import com.example.scoutkt.data.remote.crypto.Crypto
import com.example.scoutkt.data.remote.crypto.CryptoResponse
import com.example.scoutkt.data.remote.crypto.HistoricalData
import com.example.scoutkt.data.remote.crypto.HistoricalResponse
import io.ktor.client.request.*
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.http.HttpHeaders
import yahoofinance.quotes.fx.FxSymbols


class GetServiceImpl(private val client: HttpClient) : GetService {

    override suspend fun getListLatest(): List<Crypto> {
        val response: CryptoResponse = client.get {
            url(HttpRoutes.LIST_LATEST + key)
        }.body()
        return response.data
    }

    override suspend fun getHistoricalData(symbols: String): List<HistoricalData> {
        val response: HistoricalResponse = client.get {
            url("https://rest.coinapi.io/v1/ohlcv/${String}/usd/2MTH/history")
            headers {
                append(HttpHeaders.Accept, "text/plain")
                append("X-CoinAPI-Key", coilApikey)
            }
        }.body()
        return response.data
    }
}