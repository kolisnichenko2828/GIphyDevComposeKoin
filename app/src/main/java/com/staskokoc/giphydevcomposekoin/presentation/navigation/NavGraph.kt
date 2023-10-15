package com.staskokoc.giphydevcomposekoin.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.staskokoc.giphydevcomposekoin.presentation.screens.GifFullscreenCompose
import com.staskokoc.giphydevcomposekoin.presentation.screens.GifsScreenCompose

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    var tempUrl = ""

    NavHost(
        navController = navController,
        startDestination = Routes.GIFS_SCREEN
    ) {

        composable(Routes.GIFS_SCREEN) {
            GifsScreenCompose() { url ->
                tempUrl = url
                navController.navigate(Routes.GIF_FULLSCREEN)
            }
        }

        composable(Routes.GIF_FULLSCREEN) {
            GifFullscreenCompose(url = tempUrl)
        }
    }
}