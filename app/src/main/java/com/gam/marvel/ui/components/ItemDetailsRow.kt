package com.gam.marvel.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gam.marvel.models.ListWrapper
import com.gam.marvel.models.OccurrenceDto

@Composable
fun ItemDetailsRow(
    list: ListWrapper<OccurrenceDto>,
    @StringRes id: Int
) {
    Column {
        Row(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .padding(5.dp)
        )
        {
            Text(
                text = list.items.size.toString() + stringResource(id),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold
            )
        }
        Column(modifier = Modifier.padding(5.dp))
        {
            list.items.forEach {
                Text(
                    text = it.name,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}



