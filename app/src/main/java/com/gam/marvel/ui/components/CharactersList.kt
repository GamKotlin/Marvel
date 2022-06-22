package com.gam.marvel.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.gam.marvel.models.CharacterMarvel

@Composable
fun CharactersList(
    characterMarvels: List<CharacterMarvel>,
    onItemClicked: (id: Long) -> Unit = { }
) {
    LazyColumn(
        contentPadding = PaddingValues(
            top = 5.dp,
            bottom = 5.dp
        )
    ) {
        items(characterMarvels) { item ->
            ItemRow(
                character = item,
                onItemClicked = onItemClicked
            )
        }
    }
}