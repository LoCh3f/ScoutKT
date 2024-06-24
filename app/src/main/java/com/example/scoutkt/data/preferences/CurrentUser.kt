package com.example.scoutkt.data.preferences

import android.content.Context
import android.content.SharedPreferences

class CurrentUser(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("currente_user", Context.MODE_PRIVATE)

    fun setCurrentUser(username: String) {
        val editor =  sharedPreferences.edit()
        editor.putString("username",username)
        editor.apply()
    }

    fun getCurrentUser(): String? {
        return sharedPreferences.getString("username",null)
    }

    fun removeCurrentUser() {
        sharedPreferences.edit().remove(sharedPreferences.getString("username",null)).apply()
    }
}