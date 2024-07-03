package com.example.scoutkt.data.db.crypto

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.scoutkt.data.db.crypto.converter.TagConverter

@Database(entities = [CryptoEntity::class], version = 2, exportSchema = false)
@TypeConverters(TagConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cryptocurrencyDao(): CryptocurrencyDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "crypto_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
