package com.example.fkbook.ui.screens.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fkbook.ui.theme.Pink600


@Composable
fun LogoFake() {
    Text(
        "facebook",
        modifier = Modifier.padding(start = 12.dp),
        color = Pink600,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ActionButton(icon: ImageVector, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Surface(
        modifier = modifier.padding(horizontal = 6.dp),
        shape = RoundedCornerShape(50),
        color = Color(0xFFDADADA)
    ) {
        IconButton(onClick = onClick, modifier = modifier.size(36.dp)) {
            Icon(icon, contentDescription = "", tint = Color(0xFF000000))
        }
    }
}


@Composable
fun HomeTopAppbar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        LogoFake()
        Row(
            modifier.padding(end = 6.dp)
        ) {
            ActionButton(Icons.Filled.Add)
            ActionButton(Icons.Filled.Search)
            ActionButton(Icons.Filled.Email)
        }
    }
}
