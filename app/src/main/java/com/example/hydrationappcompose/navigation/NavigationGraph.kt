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
        startDestination = NavigationDestination.Today.route,
        modifier = modifier
    ) {
        composable(NavigationDestination.Today.route) { TodayRoute() }
        composable(NavigationDestination.History.route) { HistoryRoute() }
        composable(NavigationDestination.Settings.route) { SettingsRoute() }
        composable(NavigationDestination.Units.route) { UnitsRoute() }
        composable(NavigationDestination.DailyGoal.route) { ContainerRoute(Container.DAILY_GOAL) }
        composable(NavigationDestination.Container1.route) { ContainerRoute(Container.CONTAINER_1) }
        composable(NavigationDestination.Container2.route) { ContainerRoute(Container.CONTAINER_2) }
        composable(NavigationDestination.Container3.route) { ContainerRoute(Container.CONTAINER_3) }
    }
}
