package com.gam.marvel.ui

import com.gam.marvel.models.CharacterMarvel

class CharacterMarvelDetails {
    data class State(
        val character: CharacterMarvel,
        val isLoading: Boolean = false
    )

    sealed class Effect {
        object Loaded : Effect()
    }
}
