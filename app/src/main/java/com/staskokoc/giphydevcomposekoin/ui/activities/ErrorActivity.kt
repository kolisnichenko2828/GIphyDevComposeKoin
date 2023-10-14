package com.staskokoc.giphydevcomposekoin.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class ErrorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = intent.getStringExtra("message")
        val cause = intent.getStringExtra("cause")
        val stackTrace = intent.getStringExtra("stackTrace")

        setContent {
            Text(text = "Message: ${message}\n\nCause: ${cause}\n\nStacktrace: ${stackTrace}")
        }
    }
}