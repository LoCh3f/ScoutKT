package com.example.scoutkt.mainui.components.home.chart

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import java.util.stream.Collector
import java.util.stream.Collectors
import kotlin.streams.toList

@SuppressLint("DefaultLocale")
@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun LineChart(price: Double, change1h: Float, change24h: Float,change7d: Float,change30d: Float,change60d: Float,change90d: Float) {
    val  steps = 6
    val previousValues = listOf(
        price.toFloat(),
        previousVal(change90d, price),
        previousVal(change60d, price),
        previousVal(change30d, price),
        previousVal(change7d, price),
        previousVal(change24h, price),
        previousVal(change1h, price)
    )

    val pointsData = previousValues.stream()
        .map { v -> Point(previousValues.indexOf(v).toFloat(),v.toFloat()) }
        .collect(Collectors.toList())


    val label = listOf(
        "90d",
        "60d",
        "30d",
        "7d",
        "24h",
        "1h",
        "Now")
    val xAxisData = AxisData.Builder()
        .axisStepSize(50.dp)
        .backgroundColor(Color.White)
        .steps(label.size - 1 )
        .labelData { i -> label[i] }
        .axisLabelColor(MaterialTheme.colorScheme.tertiary)
        .axisLineColor(MaterialTheme.colorScheme.tertiary)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        .backgroundColor(Color.White)
        .labelData {i -> previousValues.sorted()[i].toString()}
        .axisLabelDescription { "$" }
        .axisLineColor(MaterialTheme.colorScheme.tertiary)
        .axisLabelColor(MaterialTheme.colorScheme.tertiary)
        .build()

    val lineCharData = LineChartData(
        paddingRight = 0.dp,
        paddingTop = 35.dp,
        bottomPadding = 0.dp,
        containerPaddingEnd = 0.dp,
        backgroundColor = Color.White,

        linePlotData = LinePlotData(
            lines = listOf(
                Line(dataPoints = pointsData,
                    LineStyle(
                        color = MaterialTheme.colorScheme.tertiary,
                        lineType = LineType.SmoothCurve(isDotted = false)
                    ), IntersectionPoint(
                        color = MaterialTheme.colorScheme.tertiary
                    ),
                    SelectionHighlightPoint(),
                    ShadowUnderLine(alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(MaterialTheme.colorScheme.inversePrimary,Color.White)
                        )
                    ),
                    SelectionHighlightPopUp(popUpLabel =  { x, y ->
                        val xLabel = "Price ${label.get(x.toInt())} Ago:"
                        val yLabel = "$ ${String. format("%.2f", y)}"
                        "$xLabel $yLabel"     })
                )

            ),
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines()
    )

    co.yml.charts.ui.linechart.LineChart(modifier = Modifier.height(400.dp).fillMaxWidth().clip(
        RoundedCornerShape(16.dp)
    ),
        lineChartData = lineCharData)

}

private fun previousVal(variation: Float, actualPrice: Double): Float {
    return (actualPrice / (1 - (variation / 100))).toFloat()
}
