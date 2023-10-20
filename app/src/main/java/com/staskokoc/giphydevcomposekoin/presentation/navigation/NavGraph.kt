package com.staskokoc.giphydevcomposekoin.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.staskokoc.giphydevcomposekoin.presentation.activities.ConnectivityLiveData
import com.staskokoc.giphydevcomposekoin.presentation.screens.GifFullscreenCompose
import com.staskokoc.giphydevcomposekoin.presentation.screens.GifsScreenCompose
import com.staskokoc.giphydevcomposekoin.presentation.screens.NoInternetScreenCompose

@Composable
fun NavGraph(connectivityLiveData: ConnectivityLiveData) {
    var tempUrl = ""
    val navController = rememberNavController()

    val isConnected = connectivityLiveData.observeAsState()
    LaunchedEffect(isConnected.value) {
        if (isConnected.value!!) {
            if (navController.currentDestination?.route == Routes.NO_INTERNET_SCREEN) {
                navController.popBackStack()
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = Routes.GIFS_SCREEN
    ) {

        composable(Routes.GIFS_SCREEN) {
            if (isConnected.value!!) {
                GifsScreenCompose() { url ->
                    tempUrl = url
                    navController.navigate(Routes.GIF_FULLSCREEN)
                }
            } else if (navController.currentDestination?.route != Routes.NO_INTERNET_SCREEN) {
                navController.navigate(Routes.NO_INTERNET_SCREEN)
            }
        }

        composable(Routes.GIF_FULLSCREEN) {
            if (isConnected.value!!) {
                GifFullscreenCompose(url = tempUrl)
            }  else if (navController.currentDestination?.route != Routes.NO_INTERNET_SCREEN) {
                navController.navigate(Routes.NO_INTERNET_SCREEN)
            }
        }

        composable(Routes.NO_INTERNET_SCREEN) {
            NoInternetScreenCompose()
        }
    }
}