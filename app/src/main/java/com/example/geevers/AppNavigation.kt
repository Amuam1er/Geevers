package com.example.geevers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.composable

@Composable
fun AppNavigation() {
    val navController = androidx.navigation.compose.rememberNavController()
    var donationAmount by remember { mutableStateOf("") }

    androidx.navigation.NavHost(navController = navController, startDestination = "donation") {
        composable("donation") {
            DonationScreen(
                onDonate = { amount ->
                    donationAmount = amount
                    navController.navigate("success")
                },
                onViewDetails = { navController.navigate("details") }
            )
        }
        composable("success") { SuccessScreen(amount = donationAmount) { navController.navigate("donation") } }
        composable("details") { CauseDetailsScreen() }
    }
}