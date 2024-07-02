package com.example.scoutkt.data.preferences

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import androidx.core.net.toUri
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserPreferences(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    private val gson = Gson()

    private fun getUsers(): MutableList<User> {
        val usersJson = sharedPreferences.getString("users", null)
        return if (usersJson != null) {
            val type = object : TypeToken<MutableList<User>>() {}.type
            gson.fromJson(usersJson, type)
        } else {
            mutableListOf()
        }
    }

    private fun saveUsers(users: List<User>) {
        val editor = sharedPreferences.edit()
        val usersJson = gson.toJson(users)
        editor.putString("users", usersJson)
        editor.apply()
    }

    fun saveUser(username: String, email: String, password: String, profileImagePath: String? = null) {
        val users = getUsers()
        users.removeAll { it.username == username }
        users.add(User(username, email, password, profileImagePath))
        saveUsers(users)
    }

    fun getUser(email: String): User? {
        val users = getUsers()
        return users.find { it.email == email }
    }

    fun authUser(email: String, password: String): Boolean {
        return getUsers().stream().anyMatch { user -> user.email ==email && user.password == password }
    }

    fun removeUser(email: String) {
        val users = getUsers()
        users.removeAll { it.email == email }
        saveUsers(users)
    }

    fun saveImage(email: String, profileImagePath: String) {
        val users = getUsers()
        val userIndex = users.indexOfFirst { it.email == email }
        if (userIndex != -1) {
            users[userIndex].profileImagePath = profileImagePath
            saveUsers(users) // Salva gli utenti aggiornati nella SharedPreferences
        }
    }

    fun getImageUri(email: String): Uri? {
        return getUser(email)?.profileImagePath?.toUri()
    }
}
