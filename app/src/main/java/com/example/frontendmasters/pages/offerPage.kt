package com.example.frontendmasters.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontendmasters.R


@Composable
fun OfferPage(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .padding(10.dp)) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())
            .padding(vertical = 10.dp)) {
            for(i in 1..5) {
                Offer(title = "Offer $i", description = "Offer ${i*(100-43*2)}%")
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }
}


@Composable
fun Offer(title:String, description:String) {
Card (
    elevation = CardDefaults.cardElevation(
        defaultElevation = 10.dp
    ),
    shape = RoundedCornerShape(5)
){
    Box(
        modifier = Modifier
            .height(200.dp)
            //.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.offerbg),
            contentDescription = "BG",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                title,
                style = MaterialTheme.typography.titleLarge,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Black,
                color = Color.White,
                modifier = Modifier
                    .padding(0.dp, 50.dp, 0.dp, 0.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Card(
                shape = RoundedCornerShape(25),
                border = BorderStroke(1.5.dp, Color.Black),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Text(
                    description,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black,
                    softWrap = true,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }
    }
}
}

