package com.example.firstprojectcompose.models

data class CharacterUiState (
    val photos:List<SingleCharacter > = emptyList()
)
data class SingleCharacter (
    val photo:Int
)
