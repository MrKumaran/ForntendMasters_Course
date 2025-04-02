package com.example.frontendmasters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import com.example.frontendmasters.ui.theme.FrontendMastersTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataManager = ViewModelProvider(this)
            .get(DataManager::class.java)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            FrontendMastersTheme {
                App(dataManager)
            }
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun FirstCompose(){
//    var name = remember { mutableStateOf("") }
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .border(1.dp, Color.Red),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            "First try ${name.value}",
//            modifier = Modifier
//                .padding(20.dp, 130.dp)
//                .background(color = Color.Cyan)
//                .padding(20.dp, 10.dp)
//        )
//        TextField(value = name.value, onValueChange = {
//            name.value = it
//        },
//            modifier = Modifier
//                .padding(20.dp, 0.dp)
//                .background(color = Color.Cyan)
//
//        )
//    }
//}