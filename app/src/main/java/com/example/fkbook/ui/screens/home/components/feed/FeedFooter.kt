package com.example.fkbook.ui.screens.home.components.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fkbook.ui.components.LoveCIcon

@Composable
fun FeedFooter() {
    /*Reaction info */
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Row() {
            LoveCIcon(Modifier.size(24.dp))

            Icon(Icons.Filled.Favorite, contentDescription = "")
        }
    }
}