package com.greaper.presentation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.greaper.presentation.auth.login.LoginScreen

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen("login")
    object Register : AuthScreen("register")

    companion object {
        const val route = "auth"
    }
}

fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(startDestination = AuthScreen.Login.route, route = AuthScreen.route) {
        composable(AuthScreen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(AuthScreen.Register.route) {
            // Register Screen
        }
    }
}