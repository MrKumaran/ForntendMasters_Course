package com.example.frontendmasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun App() {
Scaffold (
    topBar = {
        App_Title()
            },
    bottomBar = {
        Text(
            text = "This is the bottom",
            modifier = Modifier.padding(20.dp)
        )
    }
    )
    {
        OfferPage(modifier = Modifier.padding(it))
    }
}

@Composable
fun App_Title() {
    Box(modifier = Modifier){
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