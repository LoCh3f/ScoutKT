package com.example.scoutkt.login
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.State
import com.example.scoutkt.data.preferences.UserPreferences
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _loginResult = mutableStateOf<Result?>(null)
    val loginResult: State<Result?> = _loginResult

    fun login(context: Context, email: String, password: String) {
        viewModelScope.launch {
            val userPreferences = UserPreferences(context)
            val savedUser = userPreferences.getUser()

            _loginResult.value = if (email == savedUser.first && password == savedUser.second) {
                Result.Success
            } else {
                Result.Error("Invalid credentials")
            }
        }
    }

    sealed class Result {
        data object Success : Result()
        data class Error(val message: String) : Result()
    }
}
