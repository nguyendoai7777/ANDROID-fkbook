package com.example.fkbook.ui.screens.home.components.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Feed() {
    Column(Modifier.background(Color.White).fillMaxWidth()) {
        FeedHeader() {
            Text(text = "tada")
        }
        FeedBody()
        FeedFooter()
    }
}