package com.gam.marvel.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gam.marvel.ui.NavigationKeys
import com.gam.marvel.interactors.CharacterInteractor
import com.gam.marvel.models.CharacterMarvel
import com.gam.marvel.ui.CharacterMarvelDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewmodel @Inject constructor(
    private val stateHandle: SavedStateHandle,
    private val interactor: CharacterInteractor
) : ViewModel() {

    var state by mutableStateOf(CharacterMarvelDetails.State(CharacterMarvel(), isLoading = true))
        private set

    var effects = Channel<CharacterMarvelDetails.Effect>(Channel.UNLIMITED)
        private set

    init {
        viewModelScope.launch {
            val itemId = stateHandle.get<String>(NavigationKeys.Arg.ITEM_ID)
                ?: throw IllegalStateException().fillInStackTrace()

            interactor.getById(itemId.toLong()) { result ->
                result.onSuccess {
                    viewModelScope.launch {
                        state = state.copy(character = it.data!!.results!![0], isLoading = false)
                        effects.send(CharacterMarvelDetails.Effect.Loaded)
                    }
                }
                result.onFailure {
                    state = state.copy(character = CharacterMarvel(), isLoading = false)
                }
            }
        }
    }
}