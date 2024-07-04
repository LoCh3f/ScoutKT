package com.example.scoutkt

import android.service.autofill.FillEventHistory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scoutkt.data.db.crypto.CryptoEntity
import com.example.scoutkt.data.CryptoRepository
import com.example.scoutkt.data.remote.crypto.HistoricalData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import yahoofinance.quotes.fx.FxSymbols

class CryptoViewModel(private val repository: CryptoRepository) : ViewModel() {

    private val _cryptos = MutableLiveData<List<CryptoEntity>>()
    val cryptos: LiveData<List<CryptoEntity>> get() = _cryptos
    private val _history = MutableLiveData<List<HistoricalData>>()
    val history: LiveData<List<HistoricalData>> get() = _history

    init {
        fetchCryptos()
    }

    private fun fetchCryptos() {
        viewModelScope.launch(Dispatchers.IO) {
            val cryptosFromRepo = repository.getAllCryptos()
            _cryptos.postValue(cryptosFromRepo)
        }
    }

    fun refreshCryptos() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchLatestCryptos()
            fetchCryptos() // Aggiorna la lista locale dei cryptos dopo aver recuperato quelli più recenti
        }
    }

    fun refreshHistory(symbols: String) {
        viewModelScope.launch(Dispatchers.IO){
            _history.postValue(repository.getHistoricalFromSymbol(symbols))
        }
    }


}
