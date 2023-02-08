package com.example.fkbook.ui.screens.home.components.feed

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fkbook.R
import com.example.fkbook.ui.components.LoveCIcon

val gFontSize = 13.sp

@Composable
fun FeedFooter(hasComments: Boolean, openCommentSheet: () -> Unit = {}) {
    val configuration = LocalConfiguration.current.screenWidthDp.dp
    /*Reaction info */
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LoveCIcon(Modifier.size(20.dp))
            Text(
                "Some one and more one",
                fontSize = gFontSize,
                modifier = Modifier.padding(start = 5.dp)
            )
            /*Icon(Icons.Filled.Favorite, contentDescription = "")*/
        }
        Row {
            Text("10 bình luận", fontSize = gFontSize)
            /*Icon(painterResource(id = R.drawable.comment_outline_24), contentDescription = "")*/
        }
    }
    Divider(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 0.dp)
    )
    Row(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 0.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val width = (configuration - 24.dp) / 3 - 0.dp
        FooterButton(
            modifier = Modifier
                .width(width)
                .padding(0.dp),
            icon = painterResource(id = R.drawable.filled_like),
            text = "Thích",
            contentDesc = "share",
        )
        FooterButton(
            modifier = Modifier
                .width(width)
                .padding(0.dp),
            icon = painterResource(id = R.drawable.comment_outline_24),
            text = "Bình luận",
            contentDesc = "comment",
            onClick = openCommentSheet
        )
        FooterButton(
            modifier = Modifier
                .width(width)
                .padding(0.dp),
            icon = painterResource(id = R.drawable.filled_share),
            text = "Chia sẻ",
            contentDesc = "share",
            flipHorizontal = true,
        )
    }
    if (hasComments) Divider(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 0.dp)
    )
}

@Composable
fun FooterButton(
    modifier: Modifier = Modifier,
    icon: Painter,
    text: String,
    onClick: () -> Unit = {},
    contentDesc: String = "",
    iconSize: Dp = 24.dp,
    flipHorizontal: Boolean = false,
    backgroundColor: Color = Color.White
) {
    val flip = if (flipHorizontal) -1f else 1f
    Button(
        onClick = onClick,
        modifier = modifier,
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, focusedElevation = 0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                icon,
                contentDescription = contentDesc,
                modifier = Modifier
                    .size(iconSize)
                    .scale(scaleX = flip, scaleY = 1f)
                    .padding(end = 4.dp)
            )
            Text(text)
        }
    }
}