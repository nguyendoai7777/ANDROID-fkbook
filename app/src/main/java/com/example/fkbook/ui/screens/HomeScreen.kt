package com.example.fkbook.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun HomeTopAppbar() {
    TopAppBar(

        backgroundColor = Color.Transparent,
        elevation = 2.dp,
        content = {
            Text("Facebook")
        }
    )
}

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {HomeTopAppbar()}
    ) {
        Surface(modifier = Modifier.padding(it)) {

        }
    }
}