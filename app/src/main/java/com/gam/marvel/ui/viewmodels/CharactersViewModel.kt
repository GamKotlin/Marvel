package com.gam.marvel.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gam.marvel.interactors.CharacterInteractor
import com.gam.marvel.ui.CharactersMarvel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val interactor: CharacterInteractor
) : ViewModel() {

    var state by mutableStateOf(CharactersMarvel.State(list = listOf(), isLoading = true))
        private set

    var effects = Channel<CharactersMarvel.Effect>(Channel.UNLIMITED)
        private set

    init {
        interactor.getAll { result ->
            result.onSuccess {
                viewModelScope.launch {
                    state = state.copy(list = it.data!!.results!!, isLoading = false)
                    effects.send(CharactersMarvel.Effect.Loaded)
                }
            }
            result.onFailure {
                state = state.copy(list = emptyList(), isLoading = false)
            }
        }
    }
}





