package com.example.frontendmasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.frontendmasters.DataManager
import com.example.frontendmasters.ItemInCart
import com.example.frontendmasters.Product

@Composable
fun OrderPage(dataManager: DataManager,  modifier: Modifier = Modifier) {
    LazyColumn (
        modifier = modifier
    ){
        if (dataManager.cart.isEmpty()) {
            item {
                Card (
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 15.dp,
                            vertical = 20.dp
                        )
                        .height(200.dp)
                )
                {
                    Text(
                        text = "Cart is empty",
                        modifier = Modifier
                            .padding(vertical = 80.dp, horizontal = 130.dp)
                            .fillMaxWidth(),
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }

        } else {
            items(dataManager.cart) { product ->
                    Card(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 10.dp
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 15.dp,
                                vertical = 20.dp
                            )
                            .height(240.dp)
                    ){
                        CartItem(
                            product,
                            onDelete = {
                                dataManager.cartRemove(it)
                            }
                        )
                    }
                }
            }
        }
    }

@Composable
fun CartItem(it: ItemInCart, onDelete:(Product) -> Unit){
    Column {
        AsyncImage(
            model = it.product.imageUrl,
            contentDescription = "Image for ${it.product.name}",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 15.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${it.quantity}",
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = it.product.name,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = "$${it.product.price * it.quantity}",
                fontWeight = FontWeight.ExtraBold
            )
            Image(
                imageVector = Icons.Outlined.Delete,
                contentDescription = "Delete",
                modifier = Modifier.padding(end = 20.dp)
                    .clickable {
                        onDelete(it.product)
                    }
            )
        }
    }
}

