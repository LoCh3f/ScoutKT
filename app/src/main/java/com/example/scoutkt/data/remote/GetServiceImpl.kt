package com.example.scoutkt.data.remote

import com.example.scoutkt.data.remote.crypto.Crypto
import com.example.scoutkt.data.remote.crypto.CryptoResponse
import io.ktor.client.request.*
import io.ktor.client.*
import io.ktor.client.call.body


class GetServiceImpl(private val client: HttpClient) : GetService {

    override suspend fun getListLatest(): List<Crypto> {
        val response: CryptoResponse = client.get {
            url(HttpRoutes.LIST_LATEST + key)
        }.body()
        return response.data
    }
}