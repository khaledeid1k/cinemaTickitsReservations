package com.example.firstprojectcompose.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstprojectcompose.ui.theme.black
import com.example.firstprojectcompose.ui.theme.gray

@Composable
fun singleRate(
    text1:String,
    text2:String="",
    text3:String,
    modifier: Modifier=Modifier
){
    Column (modifier = modifier.padding(19.dp),
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){

        Row(
            horizontalArrangement=  Arrangement.Center,
            verticalAlignment = Alignment.Top

        ) {
            Text(
                text = text1,
                style =  TextStyle(fontSize =19.sp, color = black),
                textAlign = TextAlign.Center,
                color = black,
                modifier = Modifier,

            )
            Text(
                text = text2,
                style =  TextStyle(fontSize =19.sp, color = black),
                textAlign = TextAlign.Center,
                color = gray,
                modifier = Modifier
            )
        }
        Text(
            text = text3,
            style =  TextStyle(fontSize =19.sp, color = black),
            textAlign = TextAlign.Center,
            color = gray,

            modifier = Modifier

        )

    }
}