package com.example.scoutkt.data.db.crypto
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CryptocurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCryptocurrency(cryptocurrency: Cryptocurrency)

    @Query("SELECT * FROM cryptocurrencies WHERE id = :id")
    suspend fun getCryptocurrencyById(id: Long): Cryptocurrency?

    @Query("SELECT * FROM cryptocurrencies ORDER BY cmcRank ASC")
    suspend fun getAllCryptocurrencies(): List<Cryptocurrency>

    @Query("DELETE FROM cryptocurrencies")
    suspend fun deleteAllCryptocurrencies()

    @Query("SELECT * FROM cryptocurrencies WHERE name IN (:cryptoNames)")
    suspend fun getCryptocurrenciesByName(cryptoNames: List<String>): List<Cryptocurrency>
}
