package com.example.fkbook.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fkbook.common.constants.CircleShape
import com.example.fkbook.ui.theme.LoveColor

@Composable
fun LoveCIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(LoveColor)
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .padding(3.dp)
        )
    }
}