package com.example.scoutkt.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FinanceEntity::class], version = 1)
abstract class DbHolder: RoomDatabase() {
    abstract fun stockDao() : MarketDao
}