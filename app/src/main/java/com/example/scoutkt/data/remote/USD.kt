package com.example.scoutkt.data.remote

import android.health.connect.datatypes.units.Percentage
import android.health.connect.datatypes.units.Volume
import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
data class USD(
    var price: Double,
    var volume_24h: Double,
    var volume_change_24h: Double,
    var percent_change_1h: Double,
    var percent_change_24h:Double,
    var percent_change_7d: Double,
    var percent_change_30d:Double,
    var percent_change_60d: Double,
    var percent_change_90d: Double,
    var market_cap: Float,
    var market_cap_dominance: Double,
    var fully_diluted_market_cap: Double,
    var tvl: Double?,
    var last_updated: String
    )
