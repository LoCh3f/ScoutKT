package com.example.scoutkt.mainui.components.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.scoutkt.R
import com.example.scoutkt.data.db.crypto.CryptoEntity

@Composable
fun StockCard(
    cryptoEntity: CryptoEntity, // Passa l'oggetto CryptoEntity come argomento
    onHeartClick: () -> Unit // Azione da eseguire quando si clicca sul cuore
) {
    Card(
        modifier = Modifier
            .fillMaxWidth() // Occupa tutta la larghezza dello schermo
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        var expanded by remember { mutableStateOf(false) }
        var isHeartSelected by remember { mutableStateOf(false) }

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
                Image(
                    painter = painterResource(R.drawable.baseline_home_24),
                    contentDescription = "Stock Image",
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "${cryptoEntity.percentChange1h}%",
                    style = MaterialTheme.typography.bodyLarge,
                    color = if (cryptoEntity.percentChange1h!! < 0) Color.Red else Color.Green
                )
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
                    Text(
                        text = "Symbol: ${cryptoEntity.symbol}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "Price: ${cryptoEntity.price}",
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
                    // Aggiungi altre informazioni necessarie
                }
            }
        }
    }
}
