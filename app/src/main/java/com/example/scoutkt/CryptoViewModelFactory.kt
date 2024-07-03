package com.example.scoutkt

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.scoutkt.data.CryptoRepository
import com.example.scoutkt.data.db.crypto.AppDatabase
import com.example.scoutkt.data.remote.GetService

class CryptoViewModelFactory(private val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val database = AppDatabase.getDatabase(app)
        val getService = GetService.create()
        val repository = CryptoRepository(database.cryptocurrencyDao(), getService)
        return CryptoViewModel(repository) as T
    }
}
