package com.example.frontendmasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text

@Preview
@Composable
fun App_Preview(){
    App()
}



@Composable
fun App() {
    var selectedRoute = remember {
        mutableStateOf(Routes.Menupage.route)
    }
Scaffold (
    contentWindowInsets = WindowInsets.safeDrawing,
    topBar = {
        App_Title()
            },
    bottomBar = {
        NavBar(
            selectedRoute.value
            ,onChange = {
                selectedRoute.value = it
            }
        )
    }
    )
    {
    when(selectedRoute.value) {
        Routes.OfferPage.route -> OfferPage(modifier = Modifier.padding(it))
        Routes.Menupage.route -> Text("Menu Page",modifier = Modifier.padding(it))
        Routes.InfoPage.route -> Text("Info Page",modifier = Modifier.padding(it))
        Routes.OrderPage.route -> Text("Order Page",modifier = Modifier.padding(it))
    }
    }
}

@Composable
fun App_Title() {
    Row (modifier = Modifier){
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(0.dp,20.dp,0.dp,0.dp)
                    .background(color = Color.Black)
                    .padding(0.dp,20.dp,230.dp,10.dp)
                    .fillMaxWidth()
                    .height(30.dp)
            )
        }
    }