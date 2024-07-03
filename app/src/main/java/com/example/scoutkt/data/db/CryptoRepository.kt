package com.example.scoutkt.data

import com.example.scoutkt.data.db.crypto.CryptocurrencyDao
import com.example.scoutkt.data.db.crypto.CryptoEntity
import com.example.scoutkt.data.remote.GetService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CryptoRepository(
    private val cryptoDao: CryptocurrencyDao,
    private val getService: GetService
) {

    suspend fun fetchLatestCryptos(): List<CryptoEntity> {
        return withContext(Dispatchers.IO) {
            val latestCryptos = getService.getListLatest()
            val cryptoEntities = latestCryptos.map { crypto ->
                CryptoEntity(
                    id = crypto.id,
                    name = crypto.name,
                    symbol = crypto.symbol,
                    slug = crypto.slug,
                    numMarketPairs = crypto.numMarketPairs,
                    dateAdded = crypto.dateAdded,
                    tags = crypto.tags,
                    maxSupply = crypto.maxSupply,
                    circulatingSupply = crypto.circulatingSupply,
                    totalSupply = crypto.totalSupply,
                    infiniteSupply = crypto.infiniteSupply,
                    platform = crypto.platform,
                    cmcRank = crypto.cmcRank,
                    selfReportedCirculatingSupply = crypto.selfReportedCirculatingSupply,
                    selfReportedMarketCap = crypto.selfReportedMarketCap,
                    tvlRatio = crypto.tvlRatio,
                    lastUpdated = crypto.lastUpdated,
                    price = crypto.quote["USD"]?.price,
                    volume24h = crypto.quote["USD"]?.volume24h,
                    volumeChange24h = crypto.quote["USD"]?.volumeChange24h,
                    percentChange1h = crypto.quote["USD"]?.percentChange1h,
                    percentChange24h = crypto.quote["USD"]?.percentChange24h,
                    percentChange7d = crypto.quote["USD"]?.percentChange7d,
                    percentChange30d = crypto.quote["USD"]?.percentChange30d,
                    percentChange60d = crypto.quote["USD"]?.percentChange60d,
                    percentChange90d = crypto.quote["USD"]?.percentChange90d,
                    marketCap = crypto.quote["USD"]?.marketCap,
                    marketCapDominance = crypto.quote["USD"]?.marketCapDominance,
                    fullyDilutedMarketCap = crypto.quote["USD"]?.fullyDilutedMarketCap,
                    tvl = crypto.quote["USD"]?.tvl
                )
            }
            cryptoDao.insertAll(cryptoEntities)
            cryptoEntities
        }
    }

    suspend fun getAllCryptos(): List<CryptoEntity> {
        return cryptoDao.getAllCryptocurrencies()
    }
}
