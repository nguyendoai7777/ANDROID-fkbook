package com.example.fkbook.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.ui.unit.LayoutDirection
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.fkbook.common.components.CrossSlide
import com.example.fkbook.common.constants.AVATAR
import com.example.fkbook.ui.screens.home.components.Reel
import com.example.fkbook.ui.screens.home.components.bottom_sheets.ProfileBottomSheet
import com.example.fkbook.ui.screens.home.components.feed.Feed
import com.example.fkbook.ui.screens.home.components.feed.FeedHeader
import com.example.fkbook.ui.screens.home.components.feed.header.ActionRelateHeader
import com.example.fkbook.ui.screens.home.components.feed.header.GroupPostsHeader
import com.example.fkbook.ui.screens.home.components.feed.header.LiveStreamHeader
import com.example.fkbook.ui.screens.home.components.feed.header.PersonalPostHeader
import com.example.fkbook.ui.screens.home.components.feed.mocks.feedWithSubHeader
import com.example.fkbook.ui.screens.home.components.feed.models.FeedActionType
import com.example.fkbook.ui.theme.DeepPink
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

enum class BottomSheetType {
    Profile,
    Comment
}

@Composable
fun FeedCreator(modifier: Modifier = Modifier) {
    var check by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth()

    ) {

        Surface(
            modifier = Modifier.padding(12.dp),
            shape = RoundedCornerShape(50),
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(45.dp)
                    .clickable { },
                model = AVATAR,
                contentDescription = ""

            )

        }
        Button(
            elevation = ButtonDefaults.elevation(0.dp),
            onClick = { },
            modifier = Modifier
                .padding(horizontal = 12.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFF3F3F3))
        ) {
            Text(text = "What are you thinking?")
        }
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier) {
            Icon(Icons.Filled.Refresh, contentDescription = "")
        }
        Checkbox(checked = check, onCheckedChange = { check = !check })
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterialApi
@Composable
fun HomeScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        Color.Transparent,
        darkIcons = true
    )
    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val coroutineScope = rememberCoroutineScope()

    var bottomSheetType by remember {
        mutableStateOf(BottomSheetType.Profile)
    }

    var currentPage by remember { mutableStateOf("Home") }
    BackHandler(true) {
        coroutineScope.launch {
            sheetState.collapse()
        }
    }
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetBackgroundColor = DeepPink,
        sheetContent = {
            when (bottomSheetType) {
                BottomSheetType.Profile -> ProfileBottomSheet("Kim Chuc")
                BottomSheetType.Comment -> Text(text = "Profile")
            }
        },
        sheetPeekHeight = 0.dp
    ) {
        CollapsingToolbarScaffold(
            modifier = Modifier,
            scrollStrategy = ScrollStrategy.EnterAlways,
            state = rememberCollapsingToolbarScaffoldState(), // provide the state of the scaffold
            toolbar = {
                HomeTopAppbar(
                    Modifier.parallax(0f)
                )
            }
        ) {
            CrossSlide(targetState = currentPage, reverseAnimation = false) {
                when (it) {
                    "Home" -> Column(
                        Modifier
                            .verticalScroll(rememberScrollState()) // main content should be scrollable for CollapsingToolbarScaffold to consume nested scroll
                            .background(color = Color(0xFFF1F1F1))
                    ) {
                        FeedCreator()
                        Reel()
                        Feed(
                            FeedActionType.PostBySelf,
                            openCommentSheet = {
                                bottomSheetType = BottomSheetType.Comment
                                currentPage = "Comment"
                            }
                        ) {
                            FeedHeader {
                                PersonalPostHeader(
                                    onOpenProfile = {
                                        bottomSheetType = BottomSheetType.Profile
                                        coroutineScope.launch {
                                            sheetState.expand()
                                        }
                                    }
                                )
                            }
                        }
                        Feed(FeedActionType.PostInGroup) {
                            FeedHeader {
                                Column {
                                    ActionRelateHeader(feedWithSubHeader)
                                    Divider(
                                        Modifier.padding(top = 2.dp, bottom = 12.dp)
                                    )
                                    GroupPostsHeader()
                                }
                            }
                        }

                        Feed {
                            FeedHeader {
                                LiveStreamHeader()
                            }
                        }

                        Feed()
                        Feed()
                    }

                    "Comment" -> Column(
                        Modifier.fillMaxSize()
                    ) {
                        Text(text = "Child Route", Modifier.clickable {
                            currentPage = "Home"
                        })
                    }
                }
            }


        }
    }

}

















