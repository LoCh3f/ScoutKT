package com.example.scoutkt.data.db.crypto
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CryptocurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCryptocurrency(cryptocurrency: CryptoEntity)

    @Query("SELECT * FROM cryptos WHERE id = :id")
    suspend fun getCryptocurrencyById(id: Long): CryptoEntity?

    @Query("SELECT * FROM cryptos ORDER BY cmcRank ASC")
    suspend fun getAllCryptocurrencies(): List<CryptoEntity>

    @Query("DELETE FROM cryptos")
    suspend fun deleteAllCryptocurrencies()

    @Query("SELECT * FROM cryptos WHERE name IN (:cryptoNames)")
    suspend fun getCryptocurrenciesByName(cryptoNames: List<String>): List<CryptoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cryptos: List<CryptoEntity>)
}
