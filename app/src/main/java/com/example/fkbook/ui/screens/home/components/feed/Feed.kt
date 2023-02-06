package com.example.fkbook.ui.screens.home.components.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Feed(/*feed: FeedProps?*/) {
    Column(
        Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier.fillMaxWidth().height(12.dp).background(Color(0xFFF1F1F1)))
        FeedHeader() {
            Text(text = "tada")
        }
        FeedBody()
        FeedFooter(false)
    }
}