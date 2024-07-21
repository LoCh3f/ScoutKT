package com.example.scoutkt

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.scoutkt.data.CryptoRepository
import com.example.scoutkt.data.db.crypto.AppDatabase
import com.example.scoutkt.data.remote.GetService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CryptoUpdateWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            try {
                // Recupera i dati di aggiornamento dei prezzi
                val database = AppDatabase.getDatabase(applicationContext)
                val getService = GetService.create() // Assicurati di avere un metodo create per ottenere un'istanza di GetService
                val repository = CryptoRepository(database.cryptocurrencyDao(), getService)

                 repository.fetchLatestCryptos()

                // Invia la notifica
                sendNotification("Aggiornamento Prezzi Crypto", "Le percentuali dei prezzi delle criptovalute sono state aggiornate.")
                Result.success()
            } catch (e: Exception) {
                Result.failure()
            }
        }
    }

    private fun sendNotification(title: String, message: String) {
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("crypto_updates", "Crypto Updates", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(applicationContext, "crypto_updates")
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(com.google.android.gms.base.R.drawable.common_full_open_on_phone)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)// Assicurati di avere un'icona appropriata
            .build()

        notificationManager.notify(1, notification)
    }
}
