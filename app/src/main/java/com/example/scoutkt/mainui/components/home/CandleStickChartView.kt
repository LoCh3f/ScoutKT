package com.example.scoutkt.mainui.components.home

import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.scoutkt.data.remote.crypto.HistoricalData
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.random.Random


@Composable
fun TradingViewChart(data: List<HistoricalData>) {
    val jsonData = Json.encodeToString(data)
    val htmlContent = """
        <html>
        <head>
            <script src="https://s3.tradingview.com/tv.js"></script>
        </head>
        <body>
            <div id="chart_container" style="width: 100%; height: 100%;"></div>
            <script type="text/javascript">
                new TradingView.widget({
                    "width": "100%",
                    "height": "100%",
                    "symbol": "BITSTAMP:BTCUSD",
                    "interval": "1",
                    "container_id": "chart_container",
                    "datafeed": {
                        "getBars": function(symbolInfo, resolution, from, to, onHistoryCallback, onErrorCallback) {
                            const data = $jsonData;
                            const bars = data.map(d => ({
                                time: new Date(d.timePeriodStart).getTime(),
                                open: d.priceOpen,
                                high: d.priceHigh,
                                low: d.priceLow,
                                close: d.priceClose,
                                volume: d.volumeTraded
                            }));
                            onHistoryCallback(bars, { noData: false });
                        },
                        "subscribeBars": function(symbolInfo, resolution, onRealtimeCallback, subscribeUID, onResetCacheNeededCallback) {},
                        "unsubscribeBars": function(subscriberUID) {}
                    }
                });
            </script>
        </body>
        </html>
    """.trimIndent()

    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
            }
        },
        update = { webView ->
            webView.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null)
        },
        modifier = Modifier.fillMaxSize()
    )
}

fun generateFakeHistoricalData(): List<HistoricalData> {
    val data = mutableListOf<HistoricalData>()
    val random = Random(System.currentTimeMillis())
    var startTime = System.currentTimeMillis()

    for (i in 0..100) {
        val open = random.nextDouble(100.0, 200.0)
        val close = random.nextDouble(100.0, 200.0)
        val high = maxOf(open, close) + random.nextDouble(0.0, 10.0)
        val low = minOf(open, close) - random.nextDouble(0.0, 10.0)
        val volume = random.nextDouble(1000.0, 10000.0)
        val tradesCount = random.nextInt(50, 500)

        data.add(
            HistoricalData(
                timePeriodStart = startTime.toString(),
                timePeriodEnd = (startTime + 3600000).toString(), // 1 hour later
                timeOpen = startTime.toString(),
                timeClose = (startTime + 3600000).toString(),
                open = open,
                high = high,
                low = low,
                close = close
            )
        )

        startTime += 3600000 // Increment by 1 hour
    }

    return data
}

