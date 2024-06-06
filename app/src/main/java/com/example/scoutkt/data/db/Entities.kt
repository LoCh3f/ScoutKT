package com.example.scoutkt.data.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import yahoofinance.Stock

@Entity(tableName = "stocks")
data class FinanceEntity (
    @PrimaryKey val symbol: String,
    @Embedded val stock: Stock?
)
data class CryptoEntity(
    @PrimaryKey val symbol: String

)