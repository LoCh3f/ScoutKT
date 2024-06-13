package com.example.scoutkt.registration

import android.content.Context
import android.content.SharedPreferences

class UserPreferences(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveUser(username: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()
    }

    fun getUser(): Pair<String?, String?> {
        val username = sharedPreferences.getString("username", null)
        val password = sharedPreferences.getString("password", null)
        return Pair(username, password)
    }
}
