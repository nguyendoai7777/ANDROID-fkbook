package com.example.fkbook.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fkbook.ui.theme.OnLivestream
import java.time.format.TextStyle

@Composable
fun LiveBanner(modifier: Modifier = Modifier) {
    Text(
        text = "LIVE".uppercase(),
        modifier = modifier.background(
            OnLivestream,
            RoundedCornerShape(3.dp)
        ).padding(vertical = 2.dp, horizontal = 4.dp),
        color = Color.White,
        fontSize = 13.sp,

        )
}