package com.example.fkbook.ui.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.fkbook.common.constants.AVATAR
import com.example.fkbook.ui.screens.home.components.feed.Feed
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState


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
        Checkbox(checked = check, onCheckedChange = {check = !check})
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        Color.Transparent,
        darkIcons = true
    )
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
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()) // main content should be scrollable for CollapsingToolbarScaffold to consume nested scroll
                .background(color = Color(0xFFF1F1F1))
        ) {
            FeedCreator()
            Reel()
            Feed()
            Feed()
            Feed()
            Feed()
            Feed()
        }
    }
}

















