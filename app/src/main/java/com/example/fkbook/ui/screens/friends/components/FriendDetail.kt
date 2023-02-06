package com.example.fkbook.ui.screens.friends.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.fkbook.common.constants.CircleShape
import com.example.fkbook.ui.theme.ButtonDefaultColor
import com.example.fkbook.ui.theme.TextLight

class FriendProps(
    val firstName: String,
    val lastName: String,
    val avatarUrl: String,
    val sendAt: String,
    val includes: List<FriendProps>
) {}

enum class ButtonType {
    Invitation,
    Suggestion
}

const val AVATAR =
    "https://scontent.xx.fbcdn.net/v/t39.30808-1/318852939_565218495433671_6339389082911199872_n.jpg?stp=cp0_dst-jpg_p32x32&_nc_cat=109&ccb=1-7&_nc_sid=7206a8&_nc_ohc=clBjwsop1wEAX_QRztQ&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.xx&oh=00_AfAhrNdjZ18c5RPYqliBjO9sOBYYP_7o4AKUQp5gay4sBg&oe=63E57AC7"

@Composable
fun FriendDetail(buttonType: ButtonType = ButtonType.Invitation) {
    val screenWith = LocalConfiguration.current.screenWidthDp.dp
    val avatarWith = screenWith / 5
    val rightBoxWidth = avatarWith * 4
    val fn = "First"
    val ln = "Last"
    Row(
        modifier = Modifier.padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = AVATAR,
            contentDescription = "avatar",
            modifier = Modifier
                .size(avatarWith)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .width(rightBoxWidth)
                .padding(start = 12.dp, top = 6.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("$fn $ln", fontWeight = FontWeight.SemiBold)
                if (buttonType === ButtonType.Invitation) Text(
                    "15 tuần",
                    fontSize = 12.sp,
                    color = TextLight
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = AVATAR,
                    contentDescription = "Sub",
                    modifier = Modifier
                        .size(18.dp)
                        .clip(CircleShape)
                )
                Text(
                    "1 bạn chung",
                    modifier = Modifier.padding(start = 6.dp),
                    fontSize = 12.sp,
                    color = TextLight
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.width(rightBoxWidth / 2 - 24.dp),
                    contentPadding = PaddingValues(1.dp)
                ) {
                    Text(if (buttonType === ButtonType.Invitation) "Xác nhận" else "Thêm bạn bè")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.width(rightBoxWidth / 2 - 24.dp),
                    elevation = ButtonDefaults.elevation(0.dp, 0.dp),
                    colors = ButtonDefaults.buttonColors(ButtonDefaultColor),
                    contentPadding = PaddingValues(1.dp)
                ) {
                    Text(if (buttonType === ButtonType.Invitation) "Xóa" else "Gỡ")
                }
            }
        }
    }
}