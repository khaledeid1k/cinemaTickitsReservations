@file:OptIn(ExperimentalFoundationApi::class)

package com.example.firstprojectcompose.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firstprojectcompose.R
import com.example.firstprojectcompose.composable.chip
import com.example.firstprojectcompose.composable.MovieItem
import com.example.firstprojectcompose.ui.theme.orange
import com.example.firstprojectcompose.ui.theme.withe
import com.example.firstprojectcompose.viewmodel.MoviesViewModel
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlin.math.absoluteValue
import androidx.compose.ui.util.lerp
import androidx.constraintlayout.compose.Dimension
import com.example.firstprojectcompose.models.MoviesUiState


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun movies(
    viewModel : MoviesViewModel = hiltViewModel()

) {
    val state by viewModel.state.collectAsState()
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isStatusBarVisible = false // Status bar

    val pageCount = state.moviesList.size
    val pagerState: PagerState = rememberPagerState(initialPage = pageCount - 1)

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HomeBackground(state,pagerState)


        val (show,soon,viewPager) =
            createRefs()
        val chainOfType =
            createHorizontalChain(show,soon,
                chainStyle = ChainStyle.Packed)


        chip(text = stringResource(
            id = R.string.nowshowing),
            backgroundText = orange,
            backgroundBox = orange,
            backgroundBorder=orange,
            textColor = withe,
            textVerticalPadding = 8.dp,
            modifier = Modifier

                .constrainAs(show) {
                    top.linkTo(parent.top, margin = 50.dp)
                })
        chip(text = stringResource(id = R.string.comingsoon),
            backgroundText = Color.Transparent,
            backgroundBox = Color.Transparent,
            textColor = withe,
            textVerticalPadding = 8.dp,
            modifier = Modifier
                .padding(start = 8.dp)
                .constrainAs(soon) {
                    top.linkTo(parent.top, margin = 50.dp)
                })

        Box (
            modifier = Modifier.background(Color.Transparent)
                .constrainAs(viewPager) {
                    bottom.linkTo(parent.bottom)
                    top.linkTo(show.bottom, margin = 50.dp)
                    height = Dimension.fillToConstraints
                }
        ) {

            HorizontalPager(
                modifier = Modifier.background(Color.Transparent),
                pageCount = pageCount,
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 64.dp),
                pageSpacing = 8.dp
            ) { page: Int ->

                val item = state.moviesList[page]
                item.let {
                    Box(
                        modifier = Modifier.background(Color.Transparent)
                            .wrapContentSize()
                            .carouselTransition(page, pagerState)
                    ) {

                        MovieItem(it)
                    }
                }
            }
        }



    }

    }

@OptIn(ExperimentalFoundationApi::class)
fun Modifier.carouselTransition(page: Int, pagerState: PagerState) =
    graphicsLayer {
        val pageOffset =
            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

        val transformation = lerp(
            start = 0.8f,
            stop = 1f,
            fraction = 1f - pageOffset.coerceIn(0f, 1f)
        )
        alpha = transformation
        scaleY = transformation
    }
@Composable
fun HomeBackground(
    state: MoviesUiState,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    val currentPage = pagerState.currentPage

    Image(
        contentScale = ContentScale.Crop,
        painter = painterResource(id = state.moviesList[currentPage].image),
        contentDescription = "",
        modifier = modifier
            .fillMaxSize()
            .blur(40.dp),
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Transparent,
                        Color.White,
                        Color.White
                    )
                )
            )
    )
}









