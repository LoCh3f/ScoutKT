package com.example.scoutkt.mainui.components.home.card

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.scoutkt.R
import com.example.scoutkt.data.db.crypto.CryptoEntity
import com.example.scoutkt.data.remote.crypto.HistoricalData
import com.example.scoutkt.mainui.components.home.chart.LineChart

@Composable
fun StockCard(
    cryptoEntity: CryptoEntity, // Passa l'oggetto CryptoEntity come argomento
    history: List<HistoricalData>? = null,
    selected: Boolean,
    onHeartClick: () -> Unit, // Azione da eseguire quando si clicca sul cuore


) {
    Card(
        modifier = Modifier
            .fillMaxWidth() // Occupa tutta la larghezza dello schermo
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        var expanded by remember { mutableStateOf(false) }
        var isHeartSelected by remember { mutableStateOf(selected) }

        Column(
            modifier = Modifier
                .clickable { expanded = !expanded }
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                val context = LocalContext.current
                Log.d("LOGO","Logo: ${cryptoEntity.symbol}")
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .clip(CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = context.getDrawableIdByName(cryptoEntity.symbol.lowercase())),
                        contentDescription = "Logo",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                    Text(
                        text = "$${cryptoEntity.price}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "${cryptoEntity.percentChange1h}%",
                        style = MaterialTheme.typography.bodyLarge,
                        color = if (cryptoEntity.percentChange1h!! < 0) Color.Red else Color.Green
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = {
                        isHeartSelected = !isHeartSelected
                        onHeartClick()
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_assistant_24),
                        contentDescription = "Heart Icon",
                        tint = if (isHeartSelected) Color.Red else Color.Gray
                    )
                }
            }
            AnimatedVisibility(visible = expanded) {
                Column {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = cryptoEntity.symbol,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = cryptoEntity.name,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "Volume 24h: ${cryptoEntity.volume24h}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "Market Cap: ${cryptoEntity.marketCap}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Last 24 hours: ${cryptoEntity.percentChange24h}%",
                        style = MaterialTheme.typography.bodyLarge,
                        color = if (cryptoEntity.percentChange24h!! < 0) Color.Red else Color.Green
                    )
                    Text(
                        text = "Last 7 days: ${cryptoEntity.percentChange7d}%",
                        style = MaterialTheme.typography.bodyLarge,
                        color = if (cryptoEntity.percentChange7d!! < 0) Color.Red else Color.Green
                    )
                    Text(
                        text = "Last 30 days: ${cryptoEntity.percentChange30d}%",
                        style = MaterialTheme.typography.bodyLarge,
                        color = if (cryptoEntity.percentChange30d!! < 0) Color.Red else Color.Green
                    )
                    Text(
                        text = "Last 60 days: ${cryptoEntity.percentChange60d}%",
                        style = MaterialTheme.typography.bodyLarge,
                        color = if (cryptoEntity.percentChange60d!! < 0) Color.Red else Color.Green
                    )
                    Text(
                        text = "Last 90 days: ${cryptoEntity.percentChange90d}%",
                        style = MaterialTheme.typography.bodyLarge,
                        color = if (cryptoEntity.percentChange90d!! < 0) Color.Red else Color.Green
                    )
                    Spacer(modifier = Modifier.height(8.dp))
2
                    LineChart()

                }
            }
        }
    }
}
