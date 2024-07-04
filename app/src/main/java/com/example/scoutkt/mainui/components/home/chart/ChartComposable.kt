package com.example.scoutkt.mainui.components.home.chart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.tradingview.lightweightcharts.view.ChartsView

@Composable
fun ChartComposable(
    symbol: String,
    onChartReady: (ChartsView) -> Unit = {}
) {
    // Crea il componente AndroidView per ospitare il ChartsView
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            ChartsView(context).apply {
                // Inizializzazione del grafico TradingView
                // Puoi configurare il grafico qui
                // Aggiungi serie di dati, impostazioni di stile, ecc.
                onChartReady(this)
            }
        },
        update = { chartsView ->
            // Aggiorna il grafico, se necessario
            // Puoi aggiornare i dati del grafico qui
        }
    )
}
