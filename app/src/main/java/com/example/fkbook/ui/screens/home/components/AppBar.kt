package com.example.fkbook.ui.screens.home

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fkbook.ui.components.ActionButton
import com.example.fkbook.ui.theme.Pink600


@Composable
fun LogoFake() {
    Text(
        "fakebook",
        modifier = Modifier.padding(start = 12.dp),
        color = Pink600,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold
    )
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
            Spacer(modifier = Modifier.width(6.dp))
            ActionButton(Icons.Filled.Search)
            Spacer(modifier = Modifier.width(6.dp))
            ActionButton(Icons.Filled.Email)
            Spacer(modifier = Modifier.width(6.dp))
        }
    }
}
