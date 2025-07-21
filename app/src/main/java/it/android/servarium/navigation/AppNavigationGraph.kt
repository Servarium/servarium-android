package it.android.servarium.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import it.android.servarium.presentation.screens.auth.login.LoginScreen
import it.android.servarium.presentation.screens.auth.registration.RegistrationScreen

@Composable
fun AppNavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Route.LoginScreen().route,
        modifier = modifier
    ) {
        // Login Screen
        composable(
            route = Route.LoginScreen().route
        ) {
            LoginScreen(
                modifier = modifier,
                onLoginClick = {},
                onRegisterClick = {
                    navController.navigate(Route.RegistrationScreen().route)
                }
            )
        }

        // RegistrationScreen
        composable(
            route = Route.RegistrationScreen().route
        ) {
            RegistrationScreen(
                modifier = modifier,
                onRegisterClick = { navController.popBackStack() },
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}