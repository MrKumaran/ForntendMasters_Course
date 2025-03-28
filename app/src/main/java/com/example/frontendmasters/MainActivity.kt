package com.example.frontendmasters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.frontendmasters.ui.theme.FrontendMastersTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            FrontendMastersTheme {
                App()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun FirstCompose(){
    var name = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(1.dp, Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "First try ${name.value}",
            modifier = Modifier
                .padding(20.dp, 130.dp)
                .background(color = Color.Cyan)
                .padding(20.dp, 10.dp)
        )
        TextField(value = name.value, onValueChange = {
            name.value = it
        },
            modifier = Modifier
                .padding(20.dp, 0.dp)
                .background(color = Color.Cyan)

        )
    }
}