package com.example.fkbook.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.fkbook.ui.components.ActiveDetector
import com.example.fkbook.ui.components.LiveBanner
import com.example.fkbook.ui.theme.BluePrimary
import com.example.fkbook.ui.theme.OnLivestream


@Composable
fun ReelCard(feed: FeedItemData, modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val width = (configuration.screenWidthDp / 3 - 22).dp
    val height = ((configuration.screenWidthDp / 3 - 48) * 2).dp
    val activeModeColor = if (feed.activeMode == ActiveMode.Livestream) {
        OnLivestream
    } else {
        BluePrimary
    }
    Box(
        modifier = modifier
            .size(width, height)
            .padding(end = 12.dp)

    ) {
        AsyncImage(
            model = feed.media,
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
                .offset(0.dp)
                .border(
                    border = BorderStroke(1.dp, Color(0xFFE9E9E9)),
                    shape = RoundedCornerShape(8.dp)
                )
                .clip(RoundedCornerShape(8.dp))
        )
        Box(Modifier.offset(6.dp, 6.dp)) {
            AsyncImage(
                model = feed.avatar,
                contentDescription = "",
                modifier = Modifier
                    .size(width / 3)
                    .clip(CircleShape)
                    .border(
                        BorderStroke(3.dp, activeModeColor),
                        CircleShape
                    )
            )
            when (feed.onlineMode) {
                OnlineMode.Online -> ActiveDetector(
                    Modifier.align(Alignment.BottomEnd)
                )
                OnlineMode.Livestream -> LiveBanner(
                    Modifier
                        .align(Alignment.Center)
                        .offset(y = width / 6 + 5.dp)
                )
                else -> Unit
            }
        }
        Text(
            feed.useName,
            Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 6.dp, start = 6.dp),
            Color.White,
            13.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun Reel() {
    LazyRow(
        modifier = Modifier
            .padding(vertical = 12.dp)
            .background(color = Color.White)
    ) {
        FeedList.forEachIndexed { index, feed ->
            item {
                ReelCard(
                    feed = feed, modifier = Modifier.padding(
                        start = if (index == 0) {
                            12.dp
                        } else {
                            0.dp
                        },
                        top = 12.dp,
                        bottom = 12.dp
                    )
                )
            }
        }
    }
}

