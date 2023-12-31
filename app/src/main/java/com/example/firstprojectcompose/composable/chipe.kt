package com.example.firstprojectcompose.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstprojectcompose.ui.theme.black
import com.example.firstprojectcompose.ui.theme.low_gray
import com.example.firstprojectcompose.ui.theme.withe

@Composable
fun chip(
    text : String ,
     modifier :Modifier = Modifier,
     modifierText :Modifier = Modifier,
    backgroundText: Color= withe,
    backgroundBox: Color= withe,
    backgroundBorder: Color= low_gray,
    textColor: Color= black,
    textVerticalPadding: Dp = 2.dp,
    textHorizontalPadding: Dp = 0.dp,



){
    Box(
        modifier = modifier
            .wrapContentSize()
            .clip(shape = RoundedCornerShape(15.dp))
            .background(backgroundBox)
            .border(BorderStroke(1.dp, backgroundBorder,),shape = CircleShape)

    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = modifierText
                .padding(vertical =textVerticalPadding, horizontal =textHorizontalPadding  )
                .background(backgroundText)
                .padding(horizontal = 16.dp),
            style = TextStyle(fontSize = 15.sp, color = textColor)

        )


    }

}