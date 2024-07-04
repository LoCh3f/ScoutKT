package com.example.scoutkt.data.db.crypto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cryptos")
data class CryptoEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val symbol: String,
    val slug: String,
    val numMarketPairs: Int?,
    val dateAdded: String?,
    val tags: List<String>?,
    val maxSupply: Long?,
    val circulatingSupply: Double?,
    val totalSupply: Double?,
    val infiniteSupply: Boolean?,
    val cmcRank: Int?,
    val selfReportedCirculatingSupply: Double?,
    val selfReportedMarketCap: Double?,
    val tvlRatio: Double?,
    val lastUpdated: String?,
    val price: Double?,
    val volume24h: Double?,
    val volumeChange24h: Double?,
    val percentChange1h: Float?,
    val percentChange24h: Float?,
    val percentChange7d: Float?,
    val percentChange30d: Float?,
    val percentChange60d: Float?,
    val percentChange90d: Float?,
    val marketCap: Double?,
    val marketCapDominance: Double?,
    val fullyDilutedMarketCap: Double?,
    val tvl: Double?
)
