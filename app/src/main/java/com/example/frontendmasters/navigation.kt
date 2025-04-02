package com.example.frontendmasters

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontendmasters.ui.theme.Alternative1
import com.example.frontendmasters.ui.theme.OnPrimary
import com.example.frontendmasters.ui.theme.Secondary

data class NavPage(val route: String, val name: String, val icon: ImageVector)

object Routes{
    val Menupage = NavPage(route = "Menu", name = "Menu", icon = Icons.Outlined.Menu)
    val OfferPage = NavPage(route = "OfferPage", name = "OfferPage", icon = Icons.Outlined.Star)
    val OrderPage = NavPage(route = "OrderPage", name = "OrderPage", icon = Icons.Outlined.ShoppingCart)
    val InfoPage = NavPage(route = "InfoPage", name = "InfoPage", icon = Icons.Outlined.Info)

    val pages  = listOf(Menupage, OfferPage, OrderPage, InfoPage)
}

@Composable
fun NavBar(
        selectedRoute: String = Routes.Menupage.route,
        onChange: (String) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .background(Secondary)
            .padding(bottom = 20.dp)
    ) {
        for (page in Routes.pages) {
            NavBarItem(
                page = page,
                selected = selectedRoute != page.route,
                modifier = Modifier
                    .clickable{
                        onChange(page.route)
                    }
            )
        }
    }
}

@Composable
fun NavBarItem(page: NavPage, selected: Boolean = false, @SuppressLint("ModifierParameter") modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 12.dp)
    ) {
        Image(
            imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected) Alternative1 else OnPrimary
            ),
            modifier = Modifier
                .padding(top = 8.dp, bottom = 0.dp)
                .size(24.dp)
        )
        Text(page.name,
            fontSize = 12.sp,
            color = if (selected) Alternative1 else OnPrimary
        )
    }
}