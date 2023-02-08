package com.example.fkbook.ui.screens.home.components.feed.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fkbook.ui.components.ActionButton
import com.example.fkbook.ui.screens.home.components.feed.models.FeedDataMock
import com.example.fkbook.ui.screens.home.components.feed.models.RelateActionModel

@Composable
fun ActionRelateHeader(headerProps: FeedDataMock) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 12.dp,),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(text = "${headerProps.subjectFirstName} ${headerProps.subjectLastName}", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Text(
                text = " ${headerProps.action}",
                fontSize = 13.sp,
                modifier = Modifier.padding(start = 2.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            ActionButton(
                Icons.Filled.MoreVert,
                Modifier.rotate(90f),
                true,
            )
            ActionButton(
                Icons.Filled.Close,
                Modifier.rotate(90f),
                true
            )
        }

    }

}