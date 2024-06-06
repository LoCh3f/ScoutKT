package com.example.scoutkt.data.db

import androidx.room.Insert
import androidx.room.Query

interface MarketDao {
    @Query("SELECT * FROM stocks")
    fun getAll():List<FinanceEntity>

    @Insert
    fun loadStock(financeEntity: FinanceEntity)

    @Insert
    fun loadCrypto(cryptoEntity: CryptoEntity)
}