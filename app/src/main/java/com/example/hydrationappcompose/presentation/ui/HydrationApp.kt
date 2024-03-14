package com.example.hydrationappcompose.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.example.hydrationappcompose.navigation.BottomNavigationBar
import com.example.hydrationappcompose.navigation.LocalNavController
import com.example.hydrationappcompose.navigation.NavDestination
import com.example.hydrationappcompose.navigation.NavigationGraph
import com.example.hydrationappcompose.navigation.bottomNavigationItems
import com.example.hydrationappcompose.presentation.ui.components.HydrationTopAppBar

@Composable
fun HydrationApp() {
    val navController = rememberNavController()
    var currentDestination by remember {
        mutableStateOf<NavDestination>(NavDestination.Today)
    }
    val isMainDestination = currentDestination.route in bottomNavigationItems.map { it.route }

    navController.addOnDestinationChangedListener { _, destination, _ ->
        destination.route?.let {
            currentDestination = NavDestination.getDestinationByRoute(it)
        }
    }

    CompositionLocalProvider(LocalNavController provides navController) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                HydrationTopAppBar(
                    title = stringResource(currentDestination.stringRes),
                    showActionIcon = isMainDestination,
                    showNavigationIcon = !isMainDestination,
                    onNavigationIconClick = navController::popBackStack,
                    onActionIconClick = { navController.navigate(NavDestination.Settings.route) }
                )
            },
            bottomBar = { if (isMainDestination) BottomNavigationBar(navController = navController) }
        ) { paddingValues ->
            NavigationGraph(
                modifier = Modifier.padding(paddingValues),
                navController = navController
            )
        }
    }
}
