package com.example.fkbook.ui.screens.game


import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fkbook.ui.theme.ButtonDefaultColor
import com.example.fkbook.ui.theme.Pink600


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GameCenter() {
    Scaffold(
        topBar = {
            GameAppbar()
        }
    ) {
        LazyColumn {
            item {
                Divider(modifier = Modifier.padding(horizontal = 12.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Lời mời kết bạn",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Xem tất cả",
                        modifier = Modifier.clickable { },
                        color = Pink600,
                        fontSize = 15.sp
                    )
                }
            }
            items(10) {
                GameButtonDetail(GameAvatarType.Circle)

            }
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
                Spacer(modifier = Modifier.height(48.dp))
            }
        }
    }
}