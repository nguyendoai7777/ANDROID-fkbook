package com.example.fkbook.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.fkbook.common.constants.CircleShape
import com.example.fkbook.ui.theme.BorderedOnActive
import com.example.fkbook.ui.theme.OnActive

@Composable
fun ActiveDetector(modifier: Modifier = Modifier, size: Dp = 13.dp, borderWidth: Dp = 2.dp) {
    Box(
       modifier = modifier
           .size(size)
           .background(OnActive, CircleShape)
           .border(
               BorderStroke(
                   width = borderWidth,
                   color = BorderedOnActive,
               ),
               CircleShape
           )
    )
}