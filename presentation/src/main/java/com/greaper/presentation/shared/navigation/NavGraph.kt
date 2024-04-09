package com.greaper.presentation.shared.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.greaper.presentation.auth.AuthScreen
import com.greaper.presentation.auth.authGraph

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AuthScreen.route
    ) {
        authGraph(navController = navController)
//        composable(
//            route = Screen.MovieDetails.route,
//            arguments = listOf(navArgument(Constant.MOVIE_DETAILS_ARGUMENT_KEY) {
//                type = NavType.StringType
//            })
//        ) { backStackEntry ->
//            backStackEntry.arguments?.getString(Constant.MOVIE_DETAILS_ARGUMENT_KEY)
//                ?.let { MovieDetailsScreen(it,navController) }
//        }
    }
}