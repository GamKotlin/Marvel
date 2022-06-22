package com.gam.marvel.ui

import com.gam.marvel.models.CharacterMarvel

class CharactersMarvel {
    data class State(
        val list: List<CharacterMarvel> = listOf(),
        val isLoading: Boolean = false
    )

    sealed class Effect {
        object Loaded : Effect()
    }
}