package com.gam.marvel.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gam.marvel.R
import com.gam.marvel.ui.CharactersMarvel
import com.gam.marvel.ui.components.CharactersList
import com.gam.marvel.ui.components.LoadingMessage
import com.gam.marvel.ui.components.AppActionBar
import com.gam.marvel.ui.components.ErrorMessage
import com.gam.marvel.ui.theme.Typography

@Composable
fun CharactersScreen(
    state: CharactersMarvel.State,
    onNavigationRequested: (id: Long) -> Unit
) {
    Scaffold(
        topBar = { AppActionBar() }
    ) {
        Column {
            Row(
                modifier = Modifier
                    .background(Color.Black)
                    .wrapContentWidth(Alignment.End)
            ) {
                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                        .fillMaxWidth(1f)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(3.dp),
                    style = Typography.h4,
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.numberCharacters) + state.list.size.toString()
                )
            }
            Box {
                CharactersList(characterMarvels = state.list) { itemId ->
                    onNavigationRequested(
                        itemId
                    )
                }
                if (state.isLoading) {
                    LoadingMessage()
                } else if (!state.isLoading && state.list.isEmpty()) {
                    ErrorMessage(R.string.noFoundCharacters)
                }
            }
        }
    }
}