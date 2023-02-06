package com.example.fkbook.ui.screens.friends

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fkbook.ui.screens.friends.components.ButtonType
import com.example.fkbook.ui.screens.friends.components.FriendAppbar
import com.example.fkbook.ui.screens.friends.components.FriendDetail
import com.example.fkbook.ui.theme.ButtonDefaultColor
import com.example.fkbook.ui.theme.DefaultHyperlinkPrimary
import com.example.fkbook.ui.theme.Pink600


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Friend() {
    Scaffold(topBar = {
        FriendAppbar()
    }) {
        LazyColumn {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Lời mời kết bạn", fontSize = 18.sp, fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Xem tất cả",
                        modifier = Modifier.clickable { },
                        color = Pink600,
                        fontSize = 15.sp
                    )
                }
            }
            items(10) { FriendDetail() }

            item {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(vertical = 6.dp, horizontal = 12.dp)
                        .fillMaxWidth()
                        .height(30.dp),
                    contentPadding = PaddingValues(top = 0.dp),
                    colors = ButtonDefaults.buttonColors(ButtonDefaultColor)
                ) {
                    Text("Xem tất cả")
                }
                Divider(Modifier.padding(12.dp))
                Text(
                    text = "Những người bạn có thể biết",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .padding(bottom = 6.dp)
                )
            }

            items(20) { FriendDetail(ButtonType.Suggestion) }
        }
    }
}