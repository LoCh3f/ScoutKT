package com.example.scoutkt.login

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField

import com.example.scoutkt.data.preferences.UserPreferences

@Composable
fun LoginPage(
    userPreferences: UserPreferences,
    onLoginSuccess: () -> Unit,
    onRegisterClicked: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Login", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                emailError = if (it.isBlank()) "Email cannot be empty" else null
            },
            label = { Text("Email") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
            isError = emailError != null
        )
        emailError?.let { Text(text = it, color = MaterialTheme.colorScheme.error) }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = if (it.isBlank()) "Password cannot be empty" else null
            },
            label = { Text("Password") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(),
            isError = passwordError != null
        )
        passwordError?.let { Text(text = it, color = MaterialTheme.colorScheme.error) }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (email.isNotBlank() && password.isNotBlank()) {
                    val (savedEmail, savedPassword) = userPreferences.getUser()
                    if (email == savedEmail && password == savedPassword) {
                        onLoginSuccess() // Login corretto
                    } else {
                        // Credenziali errate
                        emailError = "Invalid email or password"
                        passwordError = "Invalid email or password"
                    }
                } else {
                    emailError = if (email.isBlank()) "Email cannot be empty" else null
                    passwordError = if (password.isBlank()) "Password cannot be empty" else null
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onRegisterClicked() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Go to Registration")
        }
    }
}




