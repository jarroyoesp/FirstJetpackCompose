package com.jarroyo.firstjetpackcompose.ui.compose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.jarroyo.firstjetpackcompose.R
import com.jarroyo.firstjetpackcompose.ui.AppState
import com.jarroyo.firstjetpackcompose.ui.CurrentScreen

@Composable
fun HomeComposable(appState: AppState) {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(16.dp)
    )
    {

        Log.d("HomeComposable", "Init")
        val title = Text("Welcome Home ${appState.email} - ${appState.password}")

        //ArtistCard(appState.email, {})
        ImageResource(R.drawable.ic_launcher_foreground)
    }

    BackButtonHandler {
        appState.currentScreen = CurrentScreen.LOGIN
    }
}

@Composable
fun ArtistCard(
    email: String,
    onClick: () -> Unit
) {
    val padding = 16.dp
    Column(
        Modifier
            .clickable(onClick = onClick)
            .padding(padding)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically) { Text(email) }
        Spacer(Modifier.preferredSize(padding))
        Card(elevation = 4.dp,
        modifier = Modifier.padding(16.dp)) {
            Text(text = "Tarjeta")
            ImagePicasso(url = "https://github.com/vinaygaba/CreditCardView/raw/master/images/Feature%20Image.png")
        }
    }
}