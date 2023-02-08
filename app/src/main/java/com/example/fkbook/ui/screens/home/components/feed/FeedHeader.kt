package com.example.fkbook.ui.screens.home.components.feed

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import com.example.fkbook.ui.components.ActionButton


@Composable
fun FeedHeader(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    var size by remember { mutableStateOf(0) }
    Row(
        modifier
            .padding(top = 6.dp, bottom = 6.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        content()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(end = 6.dp)
        ) {
            ActionButton(
                Icons.Filled.MoreVert,
                Modifier.rotate(90f),
                true,
                onClick = {
                        Log.d("width: ", size.dp.toString())
                }
            )
            ActionButton(
                Icons.Filled.Close,
                Modifier.rotate(90f),
                true
            )

        }
    }
}