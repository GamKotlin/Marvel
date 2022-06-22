package com.gam.marvel.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.gam.marvel.R
import com.gam.marvel.ui.theme.MarvelComicsColor
import com.gam.marvel.ui.theme.Typography

@Composable
fun AppActionBar() {
    TopAppBar(
        title = {
            Text(
                style = Typography.h1,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.app_name)
            )
        },
        backgroundColor = MarvelComicsColor,
    )
}