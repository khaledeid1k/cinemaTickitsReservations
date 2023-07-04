package com.example.firstprojectcompose.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.firstprojectcompose.R
import com.example.firstprojectcompose.models.SingleCharacter
import com.example.firstprojectcompose.ui.theme.black
import com.example.firstprojectcompose.ui.theme.orange

@Composable
fun characterItem( character: SingleCharacter){

    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape).
        background(black)
    ) {
        Image(
            painter = painterResource(character.photo),
            contentDescription = "",


            modifier = Modifier.size(90.dp).scale(1.28f)  .clip(CircleShape)
        )
    }





}