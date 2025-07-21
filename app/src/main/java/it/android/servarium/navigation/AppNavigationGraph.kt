package it.android.servarium.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import it.android.servarium.presentation.screens.login.AuthScreen

@Composable
fun AppNavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Route.AuthScreen().route,
        modifier = modifier
    ) {
        composable(
            route = Route.AuthScreen().route
        ) {
            AuthScreen(
                modifier = modifier,
                onLoginClick = {},
                onRegisterClick = {}
            )
        }
    }
}