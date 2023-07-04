package com.example.firstprojectcompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firstprojectcompose.R
import com.example.firstprojectcompose.composable.characterItem
import com.example.firstprojectcompose.composable.chip
import com.example.firstprojectcompose.composable.singleRate
import com.example.firstprojectcompose.models.CharacterUiState
import com.example.firstprojectcompose.models.SingleCharacter
import com.example.firstprojectcompose.ui.theme.background
import com.example.firstprojectcompose.ui.theme.black
import com.example.firstprojectcompose.ui.theme.brown
import com.example.firstprojectcompose.ui.theme.gray
import com.example.firstprojectcompose.ui.theme.low_gray
import com.example.firstprojectcompose.ui.theme.orange
import com.example.firstprojectcompose.ui.theme.time_backGround
import com.example.firstprojectcompose.ui.theme.withe
import com.example.firstprojectcompose.viewmodel.CharacterViewModel
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview
@Composable
fun SingleMovie(
    viewModel :CharacterViewModel= hiltViewModel()

) {
    val state by viewModel.state.collectAsState()


    val systemUiController: SystemUiController = rememberSystemUiController()

    systemUiController.isStatusBarVisible = false // Status bar
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        val chain = createHorizontalChain()
        val (backgroundIMage, card, play, close, time, rate1) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.first_photo),
            contentDescription = "",
            modifier = Modifier
                .constrainAs(backgroundIMage) {
                    top.linkTo(parent.top)
                }
                .height(350.dp)
                .fillMaxWidth(),

            contentScale = ContentScale.FillWidth,

            )
        Box(modifier = Modifier
            .clip(CircleShape)
            .size(30.dp)

            .background(brown)
            .constrainAs(close) {
                top.linkTo(parent.top, margin = 32.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        ) {
            Image(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .fillMaxSize()
                    .size(50.dp),

                painter = painterResource(R.drawable.close),
                contentDescription = "",
            )
        }

        Box(
            modifier = Modifier
                .height(20.dp)
                .width(80.dp)
                .clip(
                    shape = RoundedCornerShape(5.dp)
                )
                .background(time_backGround)
                .constrainAs(time) {
                    top.linkTo(parent.top, margin = 32.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                },

            ) {
            Row {

                Image(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .size(20.dp),

                    painter = painterResource(R.drawable.time),
                    contentDescription = "",
                )
                Text(text = stringResource(id = R.string.time), color = withe)

            }

        }

        Box(modifier = Modifier
            .clip(CircleShape)
            .size(50.dp)
            .background(orange)
            .constrainAs(play) {
                start.linkTo(backgroundIMage.start)
                end.linkTo(backgroundIMage.end)
                top.linkTo(backgroundIMage.top)
                bottom.linkTo(backgroundIMage.bottom)
            }) {
            Image(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp),
                painter = painterResource(R.drawable.play),
                contentDescription = "",
            )
        }

        Card(
            modifier = Modifier

                .constrainAs(card) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(play.bottom, margin = 130.dp)

                }


                .clip(
                    shape = RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 30.dp,
                    )
                )


        ) {
            ConstraintLayout(

                modifier =
                Modifier

                    .background(withe)
                    .padding(top = 20.dp, bottom = 120.dp)
            ) {
                val (rate1, rate2, rate3, nameOfMovie, type1,
                    type2,booking,
                    listOfCharacters,description) = createRefs()
                val chainOfRate = createHorizontalChain(rate1, rate2, rate3)
                val chainOfType =
                    createHorizontalChain(type1,type2,
                    chainStyle =ChainStyle.Packed)


                singleRate(
                    modifier =
                    Modifier.constrainAs(rate1) {},
                    text1 = stringResource(id = R.string.rate1t1)
                    , text2 = stringResource(id = R.string.rate1t2),
                    text3 = stringResource(id = R.string.rate1t3)
                )
                singleRate(
                    modifier =
                    Modifier.constrainAs(rate2) {},
                    text1 =  stringResource(id = R.string.rate2t1),
                    text3 =  stringResource(id = R.string.rate2t3)
                )
                singleRate(
                    modifier =
                    Modifier.constrainAs(rate3) {},
                    text1 = stringResource(id = R.string.rate3t1),
                    text2 = stringResource(id = R.string.rate1t2),
                    text3 =stringResource(id = R.string.rate3t3)
                )

                Text(
                    text = stringResource(id = R.string.nameOfMovie),

                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(nameOfMovie) {
                            top.linkTo(rate1.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)

                        },
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 30.sp, color = black)
                )
                chip(text = stringResource(id = R.string.type1), modifier = Modifier
                    .padding(top = 16.dp)
                    .constrainAs(type1) {
                        top.linkTo(nameOfMovie.bottom)
                    })
                chip(text = stringResource(id = R.string.type2), modifier = Modifier

                    .padding(start = 4.dp, top = 16.dp)

                    .constrainAs(type2) {
                        top.linkTo(nameOfMovie.bottom)
                    })


                characters(state,modifier= Modifier.

                constrainAs(listOfCharacters){
                    top.linkTo(type1.bottom)
                })
                Text(text = stringResource(id = R.string.description)
                    ,modifier= Modifier.

                    constrainAs(description){
                        top.linkTo(listOfCharacters.bottom)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    },
                    style = TextStyle(fontSize = 15.sp, color = black)
                )

                Row (modifier = Modifier
                    .wrapContentSize()
                    .constrainAs(booking) {
                        top.linkTo(description.bottom, margin = 32.dp)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    }
                    .clip(
                        shape = RoundedCornerShape(40.dp)
                    )
                    .background(orange)){
                    Image(
                        painter = painterResource(id = R.drawable.booking),
                        contentDescription = "",
                        modifier = Modifier.padding(top=9.dp, start = 23.dp, bottom = 12.dp, end = 6.dp)
                            .height(35.dp)
                          )
                    Text(text = stringResource(
                        id = R.string.booking),
                        style = TextStyle(fontSize = 20.sp, color = withe),
                        modifier = Modifier.padding(top=12.dp, end = 23.dp, bottom = 12.dp),
                        textAlign = TextAlign.Center,


                        )

                }
            }





        }

    }
}

@Composable
fun characters( state:CharacterUiState,
                modifier :Modifier = Modifier,
){
    LazyRow(modifier = modifier.wrapContentSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(state.photos){
            characterItem(character = it)

        }
    }
}

