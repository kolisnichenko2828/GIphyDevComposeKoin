package com.staskokoc.giphydevcomposekoin.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.staskokoc.giphydevcomposekoin.presentation.navigation.NavGraph
import com.staskokoc.giphydevcomposekoin.presentation.theme.GiphyDevComposeKoinTheme
import kotlin.system.exitProcess

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        disableCrashApp()
        setContent {
            GiphyDevComposeKoinTheme {
                NavGraph()
            }
        }
    }

    private fun disableCrashApp() {
        val exceptionHandler =
            Thread.UncaughtExceptionHandler { _: Thread, appError: Throwable ->
                openErrorActivity(appError)
            }
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler)
    }

    private fun openErrorActivity(appError: Throwable) {
        val intent = Intent(this, ErrorActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.putExtra("message", appError.message.toString())
        intent.putExtra("cause", appError.cause.toString())
        intent.putExtra("stackTrace", appError.stackTraceToString())
        startActivity(intent)
        android.os.Process.killProcess(android.os.Process.myPid())
        exitProcess(0)
    }
}