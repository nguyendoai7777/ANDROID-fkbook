package com.example.fkbook.ui.screens.home.components.feed

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.fkbook.ui.components.HashtagsMentionsTextView
import com.example.fkbook.ui.components.TextWithHyperLink

@Composable
fun FeedBody() {
    WithRawText()
}

@Composable
fun WithRawText() {
    TextWithHyperLink(
        modifier = Modifier.padding(horizontal = 12.dp),
        text = "2vs2 Random: Mạnh Hào, Anh Huy vs VaneLove, TMT\n" +
                "BLV: Mặc Radio\n" +
                "\uD83D\uDD25GTChair Dvary Butterfly – Điểm tựa thành công \uD83D\uDD25\n" +
                "Được sản xuất bởi GTChair nhà máy sản xuất ghế Ergonomic hàng đầu thế giới, ghế công thái học GTChair Dvary Butterfly bảo vệ sức khỏe, mang lại những trải nghiệm sử dụng tuyệt vời cho bạn.",
        hyperlinksText = listOf("Mặc Radio", "GTChair"),
        urls = listOf("https://24h.com.vn", "https://24h.com.vn"),
        hyperlinkDecoration = TextDecoration.None
    )
    HashtagsMentionsTextView(text = "I am @Doainn", modifier = Modifier.padding(horizontal = 12.dp),)
    HashtagsMentionsTextView(text = "vvas #JetpackCompose", modifier = Modifier.padding(horizontal = 12.dp),)
}

@Composable
fun WithBackgroundText() {
}

@Composable
fun WithVideo() {
}

@Composable
fun WithImage() {
}