package com.example.fkbook.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.fkbook.common.constants.AVATAR
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun FeedCreator(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(50)
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
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(horizontal = 12.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFF3F3F3))
        ) {
            Text(text = "What are you thinking?")
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Refresh, contentDescription = "")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val lazyListState = rememberLazyListState()
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        Color.Transparent,
        darkIcons = true
    )
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                modifier = Modifier.height(78.dp),
                elevation = 0.dp,

                ) {
                HomeTopAppbar(lazyListState)
            }
        }
    ) {
        LazyColumn(
            state = lazyListState,
            modifier = Modifier.padding(it)
        ) {
            /*stickyHeader {
                HomeTopAppbar(lazyListState)
            }*/
            item {
                FeedCreator()

            }

            items(100) {
                Text("this is body".repeat(200))
            }
        }
    }
}