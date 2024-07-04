package com.example.scoutkt.data.remote.crypto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
data class CryptoResponse(
    @SerialName("status") val status: Status,
    @SerialName("data") val data: List<Crypto>
)
@Serializable
data class Status(
    @SerialName("timestamp") val timestamp: String,
    @SerialName("error_code") val errorCode: Int,
    @SerialName("error_message") val errorMessage: String?,
    @SerialName("elapsed") val elapsed: Int,
    @SerialName("credit_count") val creditCount: Int,
    @SerialName("notice") val notice: String?,
    @SerialName("total_count") val totalCount: Int
)

@Serializable
data class Crypto(
    val id: Int,
    val name: String,
    val symbol: String,
    val slug: String,
    @SerialName("num_market_pairs") val numMarketPairs: Int?,
    @SerialName("date_added") val dateAdded: String?,
    val tags: List<String>?,
    @SerialName("max_supply") val maxSupply: Long?,
    @SerialName("circulating_supply") @Serializable(with = DoubleAsStringSerializer::class) val circulatingSupply: Double?,
    @SerialName("total_supply") @Serializable(with = DoubleAsStringSerializer::class) val totalSupply: Double?,
    @SerialName("infinite_supply") val infiniteSupply: Boolean?,
    val platform: Platform?,
    @SerialName("cmc_rank") val cmcRank: Int?,
    @SerialName("self_reported_circulating_supply") val selfReportedCirculatingSupply: Long?,
    @SerialName("self_reported_market_cap") val selfReportedMarketCap: Long?,
    @SerialName("tvl_ratio") val tvlRatio: Float?,
    @SerialName("last_updated") val lastUpdated: String?,
    val quote: Map<String, Quote>?
)

@Serializable
data class Quote(
    val price: Double?,
    @SerialName("volume_24h") val volume24h: Double?,
    @SerialName("volume_change_24h") val volumeChange24h: Double?,
    @SerialName("percent_change_1h") val percentChange1h: Float?,
    @SerialName("percent_change_24h") val percentChange24h: Float?,
    @SerialName("percent_change_7d") val percentChange7d: Float?,
    @SerialName("percent_change_30d") val percentChange30d: Float?,
    @SerialName("percent_change_60d") val percentChange60d: Float?,
    @SerialName("percent_change_90d") val percentChange90d: Float?,
    @SerialName("market_cap") val marketCap: Double?,
    @SerialName("market_cap_dominance") val marketCapDominance: Double?,
    @SerialName("fully_diluted_market_cap") val fullyDilutedMarketCap: Double?,
    val tvl: Double?
)

@Serializable
data class Platform(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("symbol") val symbol: String,
    @SerialName("slug") val slug: String,
    @SerialName("token_address") val tokenAddress: String
)