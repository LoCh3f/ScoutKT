package com.example.scoutkt.data.db.crypto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cryptocurrencies")
data class Cryptocurrency(
    @PrimaryKey val id: Long,
    val name: String,
    val symbol: String,
    val slug: String,
    val numMarketPairs: Int,
    val dateAdded: String,
    val maxSupply: Long,
    val circulatingSupply: Double,
    val totalSupply: Double,
    val infiniteSupply: Boolean,
    val cmcRank: Int,
    val lastUpdated: String,
    val price: Double,
    val volume24h: Double,
    val volumeChange24h: Double,
    val percentChange1h: Double,
    val percentChange24h: Double,
    val percentChange7d: Double,
    val percentChange30d: Double,
    val percentChange60d: Double,
    val percentChange90d: Double,
    val marketCap: Double,
    val marketCapDominance: Double,
    val fullyDilutedMarketCap: Double
)
