package com.example.scoutkt.data.remote

import com.example.scoutkt.data.remote.crypto.Crypto
import com.example.scoutkt.data.remote.crypto.HistoricalData
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import yahoofinance.quotes.fx.FxSymbols

interface GetService {

    suspend fun getListLatest(): List<Crypto>

    suspend fun getHistoricalData(symbols: String): List<HistoricalData>
    companion object {
        fun create(): GetService {
            return GetServiceImpl(
                client = HttpClient(Android) {
                    install(Logging) {
                        level = LogLevel.ALL
                    }
                    install(ContentNegotiation) {
                        json(Json {
                            ignoreUnknownKeys = true
                            isLenient = true
                        })
                    }                }
            )
        }
    }
}