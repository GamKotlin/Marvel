package com.gam.marvel.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.gam.marvel.models.CharacterMarvel
import com.gam.marvel.ui.theme.Typography

@Composable
fun ItemRow(
    character: CharacterMarvel,
    onItemClicked: (id: Long) -> Unit = { }
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.LightGray,
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
            .clickable { onItemClicked(character.id) }
    ) {
        Row(
            modifier = Modifier
                .background(Color.Black)
                .wrapContentWidth(Alignment.End)
        ) {
            Text(
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
                    .fillMaxWidth(0.7f)
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(10.dp),
                style = Typography.h2,
                textAlign = TextAlign.Center,
                text = character.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Row(modifier = Modifier.animateContentSize()) {
            Box(modifier = Modifier.padding(5.dp)) {
                ItemImage(any = character.imageUrl)
            }
            CharacterDetails(
                item = character,
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        end = 10.dp,
                        top = 20.dp,
                        bottom = 20.dp
                    )
                    .fillMaxWidth(0.80f)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}