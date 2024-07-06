package com.example.scoutkt.mainui.components.home.card
import android.content.Context
import androidx.compose.ui.platform.LocalContext

 fun Context.getDrawableIdByName(drawableName: String): Int {
    return resources.getIdentifier(drawableName, "drawable", packageName)
}



