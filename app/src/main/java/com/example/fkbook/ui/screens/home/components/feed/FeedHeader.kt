package com.example.fkbook.ui.screens.home.components.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.example.fkbook.ui.components.ActionButton


@Composable
fun FeedHeader(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Row(
        modifier
            .padding(start = 12.dp, top = 6.dp, bottom = 6.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        content()
        Row() {
            ActionButton(Icons.Filled.MoreVert, Modifier.rotate(90f), true)
            ActionButton(Icons.Filled.Close, Modifier.rotate(90f), true)

        }
    }
}