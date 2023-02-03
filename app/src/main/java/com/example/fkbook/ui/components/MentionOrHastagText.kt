package com.example.fkbook.ui.components

import android.util.Log
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.example.fkbook.ui.theme.DefaultHyperlinkPrimary

val d = "https://scontent.fhan5-11.fna.fbcdn.net/v/t39.30808-6/327813185_762744445078605_8769522239357481094_n.jpg?stp=cp6_dst-jpg_s600x600&_nc_cat=103&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=X1qDzJtYl60AX8OhoUv&_nc_ht=scontent.fhan5-11.fna&oh=00_AfALVgAI4IweIe9Bc5P4zu-M2OCGcRI6VkdiIMWxC234Ig&oe=63E1E85A"

@Composable
fun HashtagsMentionsTextView(text: String, modifier: Modifier = Modifier, onClick: (String) -> Unit = {}) {

    val colorScheme = MaterialTheme.colors
    val textStyle = SpanStyle(color = Color.Black)
    val primaryStyle = SpanStyle(color = DefaultHyperlinkPrimary)

    val hashtags = Regex("((?=[^\\w!])[#@][\\u4e00-\\u9fa5\\w]+)")

    val annotatedStringList = remember {

        var lastIndex = 0
        val annotatedStringList = mutableStateListOf<AnnotatedString.Range<String>>()

        // Add a text range for hashtags
        for (match in hashtags.findAll(text)) {

            val start = match.range.first
            val end = match.range.last + 1
            val string = text.substring(start, end)
            val replaceMentionSymbol = if (string.contains("@")) string.replace("@", "") else string

            if (start > lastIndex) {
                annotatedStringList.add(
                    AnnotatedString.Range(
                        text.substring(lastIndex, start),
                        lastIndex,
                        start,
                        "text"
                    )
                )
            }
            annotatedStringList.add(
                AnnotatedString.Range(replaceMentionSymbol, start, end, "link")
            )
            lastIndex = end
        }

        // Add remaining text
        if (lastIndex < text.length) {
            annotatedStringList.add(
                AnnotatedString.Range(
                    text.substring(lastIndex, text.length),
                    lastIndex,
                    text.length,
                    "text"
                )
            )
        }
        annotatedStringList
    }

    // Build an annotated string
    val annotatedString = buildAnnotatedString {
        annotatedStringList.forEach {
            if (it.tag == "link") {
                pushStringAnnotation(tag = it.tag, annotation = it.item)
                withStyle(style = primaryStyle) { append(it.item) }
                pop()
            } else {
                withStyle(style = textStyle) { append(it.item) }
            }
        }
    }

    ClickableText(
        text = annotatedString,
        modifier = modifier,
        onClick = { position ->
            val annotatedStringRange =
                annotatedStringList.first { it.start < position && position < it.end }
            if (annotatedStringRange.tag == "link") onClick(annotatedStringRange.item)
        }
    )
}