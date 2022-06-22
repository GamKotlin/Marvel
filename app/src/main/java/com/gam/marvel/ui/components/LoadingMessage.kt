package com.gam.marvel.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gam.marvel.R
import com.gam.marvel.ui.theme.Typography

@Composable
fun LoadingMessage() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.searching),
                textAlign = TextAlign.Start,
                style = Typography.h3
            )
            Spacer(modifier = Modifier.height(10.dp))
            CircularProgressIndicator()
        }
    }
}