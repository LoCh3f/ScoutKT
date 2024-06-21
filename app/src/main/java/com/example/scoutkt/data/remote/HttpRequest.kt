package com.example.scoutkt.data.remote
class HttpRequest {

    private val listLatest =
        "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?CMC_PRO_API_KEY=$key"

    public fun getLatest(): String {
        return this.listLatest
    }

}