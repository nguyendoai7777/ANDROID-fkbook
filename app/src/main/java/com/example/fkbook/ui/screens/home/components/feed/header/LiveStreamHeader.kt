package com.example.fkbook.ui.screens.home.components.feed.header

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.fkbook.common.constants.CircleShape
import com.example.fkbook.ui.components.LiveBanner
import com.example.fkbook.ui.theme.BluePrimary
import com.example.fkbook.ui.theme.OnLivestream
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun LiveStreamHeader() {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val rowWidth = screenWidth - 90.dp
    val isLive = true
    Row(modifier = Modifier.width(rowWidth).padding(start = 12.dp)) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .border(
                    BorderStroke(2.dp, OnLivestream), CircleShape
                )
        ) {
            Box {
                AsyncImage(
                    model = "https://scontent.fhan5-8.fna.fbcdn.net/v/t39.30808-1/323450274_2432279876925986_8513307374010547579_n.jpg?stp=cp0_dst-jpg_p40x40&_nc_cat=110&ccb=1-7&_nc_sid=c6021c&_nc_ohc=XqLDBQNtW8MAX8J_HtH&_nc_ht=scontent.fhan5-8.fna&oh=00_AfBAv62J8U1JxuDOOFhp1PxiAXRYh_bF95lf4NlX43WPcQ&oe=63E6447D",
                    contentDescription = "avatar",
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .padding(2.dp)
                        .border(
                            BorderStroke(2.dp, Color.White), CircleShape
                        )
                )
                // LiveBanner(modifier = Modifier.scale(.5f).align(Alignment.Center).offset(y = 32.dp))
            }
        }
        FlowRow(modifier = Modifier.padding(start = 6.dp)) {
            Text(text = "U98", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, modifier = Modifier.padding(end = 6.dp))
            // Text("đang phát trực tiếp ", fontSize = 14.sp, modifier = Modifier.padding(start = 6.dp))
            Text("đã đăng một video vào danh sách phát ", fontSize = 14.sp, )

            Text(text = "Age of Empires", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, )
        }

    }
}
