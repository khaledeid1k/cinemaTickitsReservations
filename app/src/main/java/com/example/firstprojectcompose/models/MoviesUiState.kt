package com.example.firstprojectcompose.models

data class MoviesUiState(
    val  moviesList : List<SingleMovie> = emptyList()
)

data class SingleMovie(
    val image:Int =0,
    val time:String ="",
    val name:String ="",
    val  categoriesList : List<SingleCategory> = emptyList(),
    )

data class SingleCategory(val category : String )