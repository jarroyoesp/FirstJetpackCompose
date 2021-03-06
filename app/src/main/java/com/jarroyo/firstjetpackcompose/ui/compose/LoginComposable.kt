package com.jarroyo.firstjetpackcompose.ui.compose

import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LifecycleOwnerAmbient
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.jarroyo.firstjetpackcompose.R
import com.jarroyo.firstjetpackcompose.domain.model.Breed
import com.jarroyo.firstjetpackcompose.ui.AppState
import com.jarroyo.firstjetpackcompose.ui.CurrentScreen
import com.jarroyo.firstjetpackcompose.ui.viewmodel.HomeViewModel

@Composable
fun LoginComposable(appState: AppState, homeViewModel: HomeViewModel) {
    val activity = (LifecycleOwnerAmbient.current as ComponentActivity)
    val number: Int by homeViewModel.randomNumber.observeAsState(0)
    val breedList: List<Breed>? by homeViewModel.breedList.observeAsState(null)

    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        val title = Text(stringResource(id = R.string.app_name))
        val emailState = remember { mutableStateOf(TextFieldValue()) }
        TextField(value = emailState.value,
            onValueChange = { emailState.value = it },
            modifier = Modifier.fillMaxWidth().padding(16.dp))

        val passwordState = remember { mutableStateOf(TextFieldValue()) }
        TextField(value = passwordState.value,
            onValueChange = { passwordState.value = it },
            modifier = Modifier.fillMaxWidth().padding(16.dp))
        
        homeViewModel.getBreedList()

        Button(onClick = { appState.currentScreen = CurrentScreen.HOME; appState.email = emailState.value.text; appState.password = passwordState.value.text}) {
            Text(text = "Aceptar ${breedList?.get(0)?.name}")
        }

        BackButtonHandler {
            activity.finish()
        }
    }
}