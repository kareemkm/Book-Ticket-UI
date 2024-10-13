package com.task.booktiket

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.task.booktiket.view.ChooseSeats
import com.task.booktiket.view.FilmInformation
import com.task.booktiket.view.Login
import com.task.booktiket.view.MobileTicket
import com.task.booktiket.view.Movies
import com.task.booktiket.view.SignIn
import com.task.booktiket.viewModel.AuthViewModel

@Composable
fun App(){
    val viewModel:AuthViewModel = viewModel()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = if (viewModel.getCurrentUser() != null) "movies" else "signing"
    ){
        composable("signing") { SignIn(navController = navController, viewModel = viewModel) }
        composable("login") { Login(navController = navController, viewModel = viewModel) }
        composable("movies") { Movies(navController = navController, viewModel = viewModel) }
        composable("filmInformation") { FilmInformation(navController = navController) }
        composable("chooseSeats") { ChooseSeats(navController = navController) }
        composable("mobileTicket") { MobileTicket(navController = navController) }
    }
}