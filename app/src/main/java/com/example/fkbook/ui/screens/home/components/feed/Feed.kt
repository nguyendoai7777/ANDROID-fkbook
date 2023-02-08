package com.example.fkbook.ui.screens.home.components.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fkbook.ui.screens.home.components.feed.body.*
import com.example.fkbook.ui.screens.home.components.feed.header.LiveStreamHeader
import com.example.fkbook.ui.screens.home.components.feed.models.FeedActionType

@Composable
fun Feed(
/*feed: FeedProps?*/
    type: FeedActionType = FeedActionType.LiveStreamed,
    openCommentSheet: () -> Unit = {},
    header: @Composable () -> Unit = {}
) {
    Column(
        Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .background(Color(0xFFF1F1F1))
        )
        header()
        /*FeedHeader {
            LiveStreamHeader()
        }*/
        when (type) {
            FeedActionType.LiveStreamed -> FeedBody()// LiveStreamPostsBody()
            FeedActionType.OnLiveStream -> FeedBody()// LiveStreamPostsBody()
            FeedActionType.Tags -> TagsPostsBody()
            FeedActionType.PostInGroup -> GroupPostsBody()
            FeedActionType.ReactionPosts -> ReactionPostsBody()
            FeedActionType.PostBySelf -> PersonalPostsBody()
            /*else -> FeedBody()*/
        }

        FeedFooter(false, openCommentSheet)
    }
}