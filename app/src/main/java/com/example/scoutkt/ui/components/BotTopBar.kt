package com.example.scoutkt.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.scoutkt.R

@Composable
fun SimpleNavigationBar() {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary)
    {
        Row (modifier = Modifier
            .wrapContentSize()
            .fillMaxWidth()
            .padding(25.dp, 0.dp, 25.dp, 0.dp)
            .height(100.dp)
            .alignByBaseline(), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically)
        {

            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(5.dp)) {
                Image(painter = painterResource(R.drawable.baseline_home_24), contentDescription = "")
            }
            Button(onClick = { /*TODO*/ },modifier = Modifier.padding(5.dp)) {
                Image(painter = painterResource(R.drawable.baseline_alarm_24), contentDescription ="" )
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(5.dp)) {
                Image(painter = painterResource(R.drawable.baseline_assistant_24), contentDescription ="" )

            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(5.dp)) {
                Image(painter = painterResource(R.drawable.baseline_app_settings_alt_24), contentDescription ="" )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHeader(activityName: String,@DrawableRes id: Int) {
    TopAppBar(title = {Text(activityName)},
                modifier = Modifier.padding(10.dp),
                navigationIcon = { Image(painter = painterResource(id), contentDescription = "")})
}