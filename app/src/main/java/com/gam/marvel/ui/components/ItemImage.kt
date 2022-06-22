package com.gam.marvel.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun ItemImage(
    any: Any,
) {
    Image(
        painter = rememberAsyncImagePainter(any),
        contentDescription = "Character image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(120.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
    )
}