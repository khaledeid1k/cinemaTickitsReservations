package com.example.firstprojectcompose.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstprojectcompose.R
import com.example.firstprojectcompose.models.SingleMovie
import com.example.firstprojectcompose.ui.theme.black

@Composable
fun MovieItem(movie: SingleMovie) {
    Column( modifier = Modifier.background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(movie.image),
            contentDescription ="" ,

            modifier = Modifier.clip(
                shape = RoundedCornerShape(40.dp)

            )    )

    Row (  modifier = Modifier
        .padding(top=32.dp)){

        Image(
            modifier = Modifier

                .padding(2.dp)
                .clip(CircleShape)
                .size(20.dp),

            painter = painterResource(R.drawable.time_gray),
            contentDescription = "",
        )
        Text(text = movie.time, color = black)

    }

    Text(
        text = movie.name,
        modifier = Modifier
            .padding(top=16.dp)
            .wrapContentSize(),
        textAlign = TextAlign.Center,
        maxLines = 2,
        style = TextStyle(fontSize = 25.sp, color = black,)
    )
    Row {
        chip(text = movie.categoriesList[0].category, modifier = Modifier
            .padding(top = 16.dp)
        )
        chip(text =  movie.categoriesList[1].category, modifier =Modifier
            .padding(top = 16.dp))

    }

}
}