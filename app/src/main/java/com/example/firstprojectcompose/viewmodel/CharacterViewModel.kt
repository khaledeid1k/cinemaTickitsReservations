package com.example.firstprojectcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.firstprojectcompose.R
import com.example.firstprojectcompose.models.CharacterUiState
import com.example.firstprojectcompose.models.SingleCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class CharacterViewModel : ViewModel() {
    private val _state = MutableStateFlow(CharacterUiState())
    val state = _state.asStateFlow()
    init {
        getCharacters()
    }
    private fun getCharacters() {
        _state.update {
            it.copy(
                photos = listOf(
                    SingleCharacter(R.drawable.actor1),
                    SingleCharacter(R.drawable.actor2),
                    SingleCharacter(R.drawable.actor3),
                    SingleCharacter(R.drawable.actor4),
                    SingleCharacter(R.drawable.actor5),
                    SingleCharacter(R.drawable.actor6),
                )
            )
        }
    }

}

