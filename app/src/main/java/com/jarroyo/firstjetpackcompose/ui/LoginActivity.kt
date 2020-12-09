package com.jarroyo.firstjetpackcompose.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.AbsoluteArrangement.Center
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jarroyo.firstjetpackcompose.R
import com.jarroyo.firstjetpackcompose.ui.compose.HomeComposable
import com.jarroyo.firstjetpackcompose.ui.compose.LoginComposable
import com.jarroyo.firstjetpackcompose.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appState = remember { AppState() }
            NavigateApp(appState, homeViewModel)
        }
    }
}

@Composable
fun NavigateApp(appState: AppState, homeViewModel: HomeViewModel) {
    // Choose which screen to show based on the value in the currentScreen variable inside AppState
    when (appState.currentScreen) {
        CurrentScreen.LOGIN -> LoginComposable(appState, homeViewModel)
        CurrentScreen.HOME -> HomeComposable(appState)
    }
}

// Simple class that we created to hold the value for the current active screen.
class AppState {
    var currentScreen by mutableStateOf(CurrentScreen.LOGIN)

    var email by mutableStateOf("")
    var password by mutableStateOf("")
}

enum class CurrentScreen {
    LOGIN,
    HOME
}



