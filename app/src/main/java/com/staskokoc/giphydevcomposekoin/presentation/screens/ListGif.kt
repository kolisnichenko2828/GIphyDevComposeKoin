package com.staskokoc.giphydevcomposekoin.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.staskokoc.giphydevcomposekoin.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ListGifCompose(url: String, onClick : (String) -> Unit) {
    GlideImage(
        model = url,
        loading = placeholder(R.drawable.ic_launcher_foreground),
        failure = placeholder(R.drawable.ic_launcher_foreground),
        contentDescription = "gif",
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .padding(top = 4.dp)
            .clickable { onClick(url) },
        contentScale = ContentScale.Crop)
}