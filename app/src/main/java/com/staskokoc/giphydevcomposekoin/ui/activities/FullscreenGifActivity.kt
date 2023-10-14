package com.staskokoc.giphydevcomposekoin.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class FullscreenGifActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {}

        val url = intent.getStringExtra("url")

        // Glide.with(this)
        //     .load(url)
        //     .error(R.drawable.ic_launcher_background)
        //     .placeholder(R.drawable.ic_launcher_foreground)
        //     .into(binding.imageView)

        // binding.imageView.setOnClickListener() {
        //     finish()
        // }
    }
}