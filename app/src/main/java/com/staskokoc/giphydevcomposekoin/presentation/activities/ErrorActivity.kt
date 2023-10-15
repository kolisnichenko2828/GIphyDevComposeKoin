package com.staskokoc.giphydevcomposekoin.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier

class ErrorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = intent.getStringExtra("message")
        val cause = intent.getStringExtra("cause")
        val stackTrace = intent.getStringExtra("stackTrace")

        setContent {
            Text(
                modifier = Modifier.verticalScroll(rememberScrollState()),
                text = "Message: ${message}\n\nCause: ${cause}\n\nStacktrace: ${stackTrace}"
            )
        }
    }
}