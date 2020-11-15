package com.jarroyo.firstjetpackcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.jarroyo.firstjetpackcompose.ui.FirstJetpackComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    Column {
        Text(text = "Hello $name!")
        Text("This is")
        Text("below each other")

        Row {
            Text("Text")
            Text("here")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstJetpackComposeTheme {
        Greeting("Android")
    }
}