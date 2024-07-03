package com.example.scoutkt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scoutkt.data.db.crypto.CryptoEntity
import com.example.scoutkt.data.CryptoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CryptoViewModel(private val repository: CryptoRepository) : ViewModel() {

    private val _cryptos = MutableLiveData<List<CryptoEntity>>()
    val cryptos: LiveData<List<CryptoEntity>> get() = _cryptos

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


}
