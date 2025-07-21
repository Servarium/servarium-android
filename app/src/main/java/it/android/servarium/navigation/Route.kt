package it.android.servarium.navigation

sealed class Route {
    data class LoginScreen(val route: String = "login") : Route()
    data class RegistrationScreen(val route: String = "registration") : Route()
}