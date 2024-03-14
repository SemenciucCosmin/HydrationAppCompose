package com.example.hydrationappcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hydrationappcompose.model.Container
import com.example.hydrationappcompose.presentation.ui.routes.ContainerRoute
import com.example.hydrationappcompose.presentation.ui.routes.HistoryRoute
import com.example.hydrationappcompose.presentation.ui.routes.SettingsRoute
import com.example.hydrationappcompose.presentation.ui.routes.TodayRoute
import com.example.hydrationappcompose.presentation.ui.routes.UnitsRoute

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavDestination.Today.route,
        modifier = modifier
    ) {
        composable(NavDestination.Today.route) { TodayRoute() }
        composable(NavDestination.History.route) { HistoryRoute() }
        composable(NavDestination.Settings.route) { SettingsRoute() }
        composable(NavDestination.Units.route) { UnitsRoute() }
        composable(NavDestination.DailyGoal.route) { ContainerRoute(Container.DAILY_GOAL) }
        composable(NavDestination.Container1.route) { ContainerRoute(Container.CONTAINER_1) }
        composable(NavDestination.Container2.route) { ContainerRoute(Container.CONTAINER_2) }
        composable(NavDestination.Container3.route) { ContainerRoute(Container.CONTAINER_3) }
    }
}
