package com.example.fkbook.ui.screens.game

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.fkbook.common.constants.CircleShape
import com.example.fkbook.ui.theme.ButtonDefaultColor

enum class GameAvatarType {
    Rounded, Circle
}

@Composable
fun GameButtonDetail(type: GameAvatarType = GameAvatarType.Rounded) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val avatarWidth = screenWidth / 6
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = "https://scontent.fhan5-9.fna.fbcdn.net/v/t39.30808-1/272919776_1126051088140907_5148334106785380390_n.jpg?stp=dst-jpg_p100x100&_nc_cat=110&ccb=1-7&_nc_sid=7206a8&_nc_ohc=Z2WyYUckY5kAX_Dms4v&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.fhan5-9.fna&oh=00_AfBwP_Fp73xc1h-aPm5kvOa_vmFolAhPl5frRuLTm_iljA&oe=63E516C1",
                contentDescription = "Tien len",
                modifier = Modifier
                    .size(avatarWidth)
                    .clip(
                        if (type === GameAvatarType.Rounded) RoundedCornerShape(5) else CircleShape
                    )
            )
            Text(text = "Tiến lên miên nam", Modifier.padding(start = 12.dp))
        }
        Button(
            onClick = { /*TODO*/ },
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(ButtonDefaultColor),
            modifier = Modifier.height(30.dp)
        ) {
            Text(text = "Chơi")
        }
    }
}