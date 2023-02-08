package com.example.fkbook.ui.screens.home.components.feed.header

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.fkbook.common.constants.CircleShape
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun GroupPostsHeader() {
    val screenWith = LocalConfiguration.current.screenWidthDp.dp
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier.padding(start = 12.dp,)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(5))
                .size(48.dp)
        ) {
            AsyncImage(
                model = "https://scontent.fhan5-2.fna.fbcdn.net/v/t39.30808-6/318434373_939191117048745_5600356562324192235_n.jpg?stp=c22.0.50.50a_cp6_dst-jpg_p50x50&_nc_cat=105&ccb=1-7&_nc_sid=70495d&_nc_ohc=Q6zlNokrAsUAX-Mt6S4&_nc_oc=AQmYVzEVifWumMlvuIE0lywlcdq5hALdhnO3sfcIPmwlHD47i_ZJhDHndWMDOhCpyec&_nc_ht=scontent.fhan5-2.fna&oh=00_AfA8XjMZza3kwbpR_lDl4lvLwo9cL8hk8Ieb-NFdbxf6Ww&oe=63E75BD9",
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(20))
            )
            Surface(
                modifier = Modifier
                    .displayCutoutPadding()
                    .size(34.dp)
                    .offset(15.dp, 15.dp),
                shape = CircleShape,
                border = BorderStroke(2.dp, Color.White)
            ) {
                AsyncImage(
                    model = "https://scontent.fhan5-2.fna.fbcdn.net/v/t39.30808-1/296135991_795037598333868_5626761009163961870_n.jpg?stp=cp0_dst-jpg_p24x24&_nc_cat=105&ccb=1-7&_nc_sid=7206a8&_nc_ohc=aoqFfwJ9yyIAX9ChKNr&_nc_ht=scontent.fhan5-2.fna&oh=00_AfCpLYS-hPF3mEcAeC0zWxuSjZy4iCn_DE2qyvc090n7YA&oe=63E7D556",
                    contentDescription = "",
                    modifier = Modifier.clip(CircleShape).scale(.85f),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Column(
            Modifier.width(screenWith - 24.dp - 72.dp - 48.dp).padding(start = 6.dp)
        ) {
            FlowRow {
                Text(
                    "Tuyển dụng HTML5, JavaScript, AngularJS, ReactJS, VueJS, Frontend, NodeJS",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Lương Bitch", fontSize = 12.sp, color = Color(0xFF949494), fontWeight = FontWeight.SemiBold)
                Text("·", Modifier.padding(horizontal = 6.dp))
                Text("4h", fontSize = 12.sp, color = Color(0xFF949494))
            }
        }
    }
}