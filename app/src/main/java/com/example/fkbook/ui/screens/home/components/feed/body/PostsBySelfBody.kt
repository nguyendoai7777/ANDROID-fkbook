package com.example.fkbook.ui.screens.home.components.feed.body

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PersonalPostsBody() {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            "Thêm tuổi nữa rồi\uD83D\uDE01\uD83D\uDE01 chúc bản thân luôn cố gắng trên con đường mình đang đi \uD83D\uDE03\uD83D\uDE03",
            Modifier.padding(horizontal = 12.dp)
        )
        AsyncImage(
            model = "https://scontent.fhan5-8.fna.fbcdn.net/v/t39.30808-6/328491925_681575590432497_4574990868410906107_n.jpg?stp=dst-jpg_s640x640&_nc_cat=110&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=kJLG0e1A-DcAX-DvHsu&_nc_oc=AQm7xFgPL52smbayWVyYwQEPFaenTA-gPqVgsnFZMeK3qotfCNNNJKe9ttMf26sSZ4g&_nc_ht=scontent.fhan5-8.fna&oh=00_AfAYXMwf12SRzTwogXxzh4ZHWsraxum7S2vTEs6TVDeP2Q&oe=63E6CDC2",
            contentDescription = "",
            modifier = Modifier.padding(top = 12.dp).width(screenWidth),
            contentScale = ContentScale.FillWidth
        )
    }
}