package com.staskokoc.giphydevcomposekoin.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
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
fun GifFullscreenCompose(url: String) {
    GlideImage(
        model = url,
        loading = placeholder(R.drawable.ic_launcher_foreground),
        failure = placeholder(R.drawable.ic_launcher_foreground),
        contentDescription = "gif",
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.surface)
            .fillMaxSize()
            .aspectRatio(1f)
            .padding(top = 4.dp),
        contentScale = ContentScale.Crop)
}