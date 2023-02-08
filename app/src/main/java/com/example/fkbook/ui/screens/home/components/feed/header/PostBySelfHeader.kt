package com.example.fkbook.ui.screens.home.components.feed.header

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.fkbook.common.constants.CircleShape

@Composable
fun PersonalPostHeader(onOpenProfile: (id: String) -> Unit = {}) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val rowWidth = screenWidth - 90.dp
    Row(
        modifier = Modifier
            .width(rowWidth)
            .padding(start = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            AsyncImage(
                model = "https://scontent.fhan5-2.fna.fbcdn.net/v/t39.30808-1/326052680_533841272051235_4448157415129599577_n.jpg?stp=cp6_dst-jpg_p40x40&_nc_cat=102&ccb=1-7&_nc_sid=7206a8&_nc_ohc=2BiRSP5_zAcAX_Gb43_&_nc_ht=scontent.fhan5-2.fna&oh=00_AfBfnV017O1tmPFdn11-Wm2_JFw5CSNnRfXoHvGhlQafjw&oe=63E76E74",
                contentDescription = "avatar",
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .clickable { onOpenProfile("1999") }
                /*.padding(2.dp)
                .border(
                    BorderStroke(2.dp, Color.White), CircleShape
                )*/
            )
        }
        Column(
            modifier = Modifier
                .width(rowWidth - 36.dp)
                .padding(start = 6.dp)
        ) {
            Text(
                "Kim Chức",
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                modifier = Modifier.clickable { onOpenProfile("1999") })
            Text("1h", color = Color(0xFF757575), fontSize = 12.sp)
        }
    }
}