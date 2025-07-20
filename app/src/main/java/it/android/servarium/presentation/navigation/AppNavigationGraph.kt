package dev.surf.retrofitlesson.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import it.android.servarium.presentation.screens.login.AuthScreen
import it.android.servarium.presentation.screens.main.MainScreen
import it.android.servarium.presentation.screens.registration.RegisterScreen

@Composable
fun AppNavigationGraph(
    startDestination: String,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier.fillMaxSize()
    ) {
        composable(Route.Login.route) {
            AuthScreen(
                onLoginClick = {
                    // TODO: Реализовать авторизацию и переход на MainScreen
                    navController.navigate(Route.MainScreen().route) {
                        popUpTo(Route.Login.route) { inclusive = true }
                    }
                },
                onRegisterClick = {
                    navController.navigate(Route.Registration.route) {
                        popUpTo(Route.Login.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Route.Registration.route) {
            RegisterScreen(
                onLoginClick = {
                    navController.navigate(Route.Login.route) {
                        popUpTo(Route.Registration.route) { inclusive = true }
                    }
                },
                onRegisterClick = {
                    // TODO: Реализовать регистрацию и переход на MainScreen
                    navController.navigate(Route.MainScreen().route) {
                        popUpTo(Route.Registration.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Route.MainScreen().route) {
            MainScreen(
                onPcClick = {},
                pcs = emptyList() // TODO: Подключить реальные данные
            )
        }
    }
}


