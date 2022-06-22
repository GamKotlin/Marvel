package com.gam.marvel.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.gam.marvel.R
import com.gam.marvel.ui.CharacterMarvelDetails
import com.gam.marvel.ui.components.*
import com.gam.marvel.ui.theme.Typography

@Composable
fun CharacterDetailsScreen(
    state: CharacterMarvelDetails.State
) {
    val character = state.character
    Scaffold(topBar = { AppActionBar() }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .background(Color.Black)
                        .wrapContentWidth(Alignment.End)
                ) {
                    ItemImage(any = character.imageUrl)
                    Text(
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .fillMaxWidth(1f)
                            .wrapContentWidth(Alignment.Start)
                            .padding(10.dp),
                        style = Typography.h2,
                        textAlign = TextAlign.Center,
                        text = character.name
                    )
                }
                ItemRowText(R.string.id)
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = character.id.toString(),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(5.dp))
                ItemRowText(R.string.modified)
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = character.modified.split('T')[0].trim(),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(5.dp))
                ItemRowText(R.string.description)
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = character.description.trim().ifEmpty { " - " },
                    textAlign = TextAlign.Start,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(5.dp))
                ItemDetailsRow(character.comics, R.string.comics)
                Spacer(modifier = Modifier.height(5.dp))
                ItemDetailsRow(character.series, R.string.series)
                Spacer(modifier = Modifier.height(5.dp))
                ItemDetailsRow(character.stories, R.string.stories)
            }
        }

        if (state.isLoading) {
            LoadingMessage()
        } else if (!state.isLoading && character.name.isEmpty()) {
            ErrorMessage(R.string.noFoundCharacter)
        }
    }
}
