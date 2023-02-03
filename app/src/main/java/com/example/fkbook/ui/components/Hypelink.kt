package com.example.fkbook.ui.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.fkbook.ui.theme.DefaultHyperlinkPrimary

@Composable
fun TextWithHyperLink(
    modifier: Modifier = Modifier,
    text: String,
    hyperlinksText: List<String>,
    textColor: Color = Color.Black,
    hyperlinkColor: Color = DefaultHyperlinkPrimary,
    hyperlinkFontSize: TextUnit = 14.sp,
    hyperlinkFontWeight: FontWeight = FontWeight.Normal,
    hyperlinkDecoration: TextDecoration = TextDecoration.Underline,
    urls: List<String>
) {
    val annotatedString = buildAnnotatedString {
        append(text)
        hyperlinksText.forEachIndexed { i, textLink ->
            val startIndex = text.indexOf(textLink)
            val endIndex = startIndex + textLink.length
            addStyle(
                style = SpanStyle(
                    color = hyperlinkColor,
                    textDecoration = hyperlinkDecoration,
                    fontSize = hyperlinkFontSize
                ),
                start = startIndex,
                end = endIndex
            )
            addStringAnnotation(
                tag = "URL",
                annotation = hyperlinksText[i],
                start = startIndex,
                end = endIndex
            )
        }
        addStyle(
            style = SpanStyle(
                fontSize = hyperlinkFontSize,
            ),
            start = 0,
            end = text.length
        )
    }
    val uri = LocalUriHandler.current

    ClickableText(text = annotatedString, modifier = modifier, onClick = {
        annotatedString.getStringAnnotations("URL", it, it)
            .firstOrNull()?.let { v ->
                uri.openUri(v.item)
            }
    })
}