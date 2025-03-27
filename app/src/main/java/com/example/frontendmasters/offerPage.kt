package com.example.frontendmasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.frontendmasters.ui.theme.Alternative1


@Preview(showBackground = true, widthDp = 400, heightDp = 600)
@Composable
fun OfferPage(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.background_pattern),
            contentDescription = "BG",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxHeight()
        )
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Offer(title = "Title_1", description = "Description 1")
            Offer(title = "Title_2", description = "Description 2")
            Offer(title = "Title_3", description = "Description 3")
            Offer(title = "Title_4", description = "Description 4")
            Offer(title = "Title_5", description = "Description 5")
            Offer(title = "Title_6", description = "Description 6")
        }
    }
}

@Composable
fun Offer(title:String, description:String) {
    Box(modifier = Modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(0.dp, 90.dp, 0.dp, 0.dp)
                    .background(color = Alternative1)

            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                description,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 50.dp)
                    .background(color = Color.Yellow)

            )
        }
    }
}

