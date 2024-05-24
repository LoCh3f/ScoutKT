package com.example.scoutkt.ui.components

import android.graphics.Paint.Align
import android.graphics.drawable.Icon
import android.icu.text.ListFormatter.Width
import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ScaffoldLayout() {
    Scaffold(modifier = Modifier,bottomBar = {
        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.primary,
        ) {
            Row (modifier = Modifier
                .wrapContentSize()
                .fillMaxWidth()
                .padding(25.dp, 0.dp, 25.dp, 0.dp)
                .height(100.dp)
                .alignByBaseline(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {

                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(5.dp)) {

                }
                Button(onClick = { /*TODO*/ },modifier = Modifier.padding(5.dp)) {

                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(5.dp)) {

                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(5.dp)) {

                }







            }

        }
    }) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding).fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Qua bisogna mettere le card")
            StockCard()
        }
        

    }
}