package it.android.servarium.navigation

sealed class Route {
    data class AuthScreen(val route: String = "auth") : Route()
}