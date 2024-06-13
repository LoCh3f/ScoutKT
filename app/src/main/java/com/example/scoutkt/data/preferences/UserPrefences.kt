package com.example.scoutkt.data.preferences

import android.content.Context
import android.content.SharedPreferences
import android.provider.ContactsContract.CommonDataKinds.Email

class UserPreferences(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveUser(username: String, email: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.putString("email",email)
        editor.putString("password", password)
        editor.apply()
    }

    fun getUser(): Pair<String?, String?> {
        val email = sharedPreferences.getString("email", null)
        val password = sharedPreferences.getString("password", null)
        return Pair(email, password)
    }
}
