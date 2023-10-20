package com.staskokoc.giphydevcomposekoin.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.staskokoc.giphydevcomposekoin.presentation.theme.GiphyDevComposeKoinTheme

class ErrorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = intent.getStringExtra("message")
        val cause = intent.getStringExtra("cause")
        val stackTrace = intent.getStringExtra("stackTrace")

        setContent {
            GiphyDevComposeKoinTheme() {
                Text(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    color = MaterialTheme.colorScheme.onSurface,
                    text = "Message: ${message}\n\nCause: ${cause}\n\nStacktrace: ${stackTrace}"
                )
            }
        }
    }
}