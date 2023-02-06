package com.example.fkbook.ui.screens.home.components.feed.models

enum class FeedActionType {
    ReactionPosts,
    OnLiveStream,
    LiveStreamed,
    PostBySelf,
    PostInGroup,
    Tags,

}

interface ReactionPostsContent {

}

interface OnLiveStreamContent {

}

interface MainSubject {
    val firstName: String
    val lastName: String
    val reputationConfirmation: Boolean
}

interface FeedProps {
    val mainSubject: MainSubject
    val action: FeedActionType
    val reactionPostsContent: ReactionPostsContent
    val onLiveStreamContent: OnLiveStreamContent
}


data class FeedCreator(
    override val mainSubject: MainSubject,
    override val action: FeedActionType,
    override val reactionPostsContent: ReactionPostsContent,
    override val onLiveStreamContent: OnLiveStreamContent,
) : FeedProps
