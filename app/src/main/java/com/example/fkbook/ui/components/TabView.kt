package com.example.fkbook.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import com.example.fkbook.ui.theme.DeepPink
import com.example.fkbook.R
import com.example.fkbook.ui.screens.friends.Friend
import com.example.fkbook.ui.screens.game.GameCenter
import com.example.fkbook.ui.screens.home.HomeScreen

val tabComposes = listOf(
    "Trang chủ" to listOf(R.drawable.nav_home, R.drawable.nav_home_active),
    "Bạn bè" to listOf(R.drawable.nav_friend, R.drawable.nav_friend_active),
    "Chơi game" to listOf(R.drawable.nav_dating, R.drawable.nav_dating_active),
    "Video" to listOf(R.drawable.nav_video, R.drawable.nav_video_active),
    "Thông báo" to listOf(R.drawable.nav_notification, R.drawable.nav_notification_active),
    "Menu" to listOf(R.drawable.nav_menu, R.drawable.nav_menu_active),
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalPagerApi
@Composable
fun TabLayout() {

    val pagerState = rememberPagerState(pageCount = tabComposes.size)

    Scaffold(
        modifier = Modifier.background(Color.White),
        bottomBar = {
            Tabs(pagerState = pagerState)
        }
    ) {
        TabsContent(pagerState = pagerState)
    }
}

@Composable
fun TopIndicator(color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .offset(y = (-46).dp)  //SmallTabHeight=48.dp - height indicator=2.dp
            .height(2.dp)
            .background(color = color)
    )
}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        TopIndicator(DeepPink, Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]))
    }
    TabRow(
        modifier = Modifier.height(48.dp),
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        contentColor = DeepPink,
        divider = {},
        indicator = indicator /*{ tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions).offset(0.dp, 0.dp),
                height = 2.dp,
                color = DeepPink
            )
        }*/
    ) {
        tabComposes.forEachIndexed { index, _ ->

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }

                }
            ) {
                Icon(
                    painter = painterResource(id = tabComposes[index].second[if (pagerState.currentPage == index) 1 else 0]),
                    modifier = Modifier.size(22.dp),
                    contentDescription = null,
                    tint = if (pagerState.currentPage == index) DeepPink else Color(0xFF636363)
                )
                Text(
                    tabComposes[index].first,
                    fontSize = 11.sp,
                    color = if (pagerState.currentPage == index) DeepPink else Color(0xFF636363)
                )
            }


            /*Tab(
                icon = {
                    Icon(
                        imageVector = tabComposes[index].second,
                        modifier = Modifier.size(15.dp),
                        contentDescription = null,
                        tint = if (pagerState.currentPage == index) DeepPink else Color(0xFF636363)
                    )
                },
                text = {
                    Text(
                        tabComposes[index].first,
                        fontSize = 13.sp,
                        color = if (pagerState.currentPage == index) DeepPink else Color(0xFF636363)
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )*/
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> HomeScreen()
            1 -> Friend()
            2 -> GameCenter()
            3 -> Column(
                Modifier.fillMaxSize()
            ) {
                Text(text = "Video")
            }
            4 -> Column(
                Modifier.fillMaxSize()
            ) {
                Text(text = "Thông báo")
            }
            5 -> Column(
                Modifier.fillMaxSize()
            ) {
                Text(text = "Menu")
            }
        }
    }
}

@Composable
fun TabContentScreen(data: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = data,

            style = MaterialTheme.typography.h5,

            color = Color.Green,

            fontWeight = FontWeight.Bold,

            //on below line we are specifying the text alignment.
            textAlign = TextAlign.Center
        )
    }
}