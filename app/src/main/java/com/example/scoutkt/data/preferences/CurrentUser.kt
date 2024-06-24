package com.example.scoutkt.data.preferences

import android.content.Context
import android.content.SharedPreferences

class CurrentUser(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("current_user", Context.MODE_PRIVATE)

    fun setCurrentUser(email: String) {
        val editor =  sharedPreferences.edit()
        editor.putString("email",email)
        editor.apply()
    }

    fun getCurrentUser(): String? {
        return sharedPreferences.getString("email",null)
    }

    fun removeCurrentUser() {
        sharedPreferences.edit().remove(sharedPreferences.getString("email",null)).apply()
    }
}