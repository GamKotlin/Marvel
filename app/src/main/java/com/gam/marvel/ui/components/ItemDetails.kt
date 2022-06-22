package com.gam.marvel.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.gam.marvel.R
import com.gam.marvel.models.CharacterMarvel

@Composable
fun CharacterDetails(
    item: CharacterMarvel?,
    modifier: Modifier
) {
    Column(
        modifier = modifier.padding(top = 30.dp)
    ) {
        Row {
            Text(
                text = stringResource(id = R.string.id),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = item!!.id.toString(),
                textAlign = TextAlign.Start
            )
        }
        Row {
            Text(
                text = stringResource(id = R.string.modified),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = item!!.modified.split('T')[0].trim(),
                textAlign = TextAlign.Start
            )
        }
        Text(
            text = stringResource(id = R.string.description),
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = item!!.description.trim().ifEmpty { " - " },
            textAlign = TextAlign.Start,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}