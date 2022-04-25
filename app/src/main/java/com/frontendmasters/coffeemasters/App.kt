package com.frontendmasters.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffemastersdemo.NavBar
import com.frontendmasters.coffeemasters.ui.theme.CoffeeMastersTheme

@Preview
@Composable
fun App_Preview() {
    CoffeeMastersTheme() {
        App()
    }
}

@Composable
fun App() {
    val selectedRoute = remember {
        mutableStateOf("menu")
    }
    Scaffold(
        topBar = { TopAppBar {
            AppTitle()
        }},
        content = {
           OffersPage()
        },
        bottomBar = {
            NavBar(
                selectedRoute = selectedRoute.value,
                onChange = {
                    selectedRoute.value = it
                })
        }
    )
}

@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Masters Logo")
    }
}