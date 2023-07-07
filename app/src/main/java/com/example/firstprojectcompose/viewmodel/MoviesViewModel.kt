package com.example.firstprojectcompose.viewmodel

import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.example.firstprojectcompose.R
import com.example.firstprojectcompose.models.CharacterUiState
import com.example.firstprojectcompose.models.MoviesUiState
import com.example.firstprojectcompose.models.SingleCategory
import com.example.firstprojectcompose.models.SingleCharacter
import com.example.firstprojectcompose.models.SingleMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class MoviesViewModel : ViewModel() {
    private val _state = MutableStateFlow(MoviesUiState())
    val state = _state.asStateFlow()

    init {
        getMovies()
    }

    private fun getMovies() {
        _state.update {
            it.copy(
                moviesList = listOf(
                    SingleMovie(
                        image = R.drawable.godfather,
                        name = "127 Hours ",
                        time = "2h 50m",
                        categoriesList = listOf(
                            SingleCategory("Biography"),
                            SingleCategory("Drama")
                        )
                    ) ,

                            SingleMovie(
                        image = R.drawable.scarface,
                        name = "E.T. the Extra-Terrestrial",
                        time = "2h 18m",
                        categoriesList = listOf(
                            SingleCategory("Family"),
                            SingleCategory("Adventure")
                        )
                    ),

                        SingleMovie(
                        image = R.drawable.photo,
                        name = "Fantastic Beats:The Secrets of Dumbledore",
                        time = "2h 23m",
                        categoriesList = listOf(
                            SingleCategory("Fantasy"),
                            SingleCategory("Adventure")
                        )
                    )
                )
            )
        }
    }

}

