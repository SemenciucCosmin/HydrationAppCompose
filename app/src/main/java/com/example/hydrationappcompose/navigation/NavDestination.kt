package com.example.hydrationappcompose.navigation

import androidx.annotation.StringRes
import com.example.hydrationappcompose.R

sealed class NavDestination(val route: String, @StringRes val stringRes: Int) {
    data object Today : NavDestination(
        route = "today_route",
        stringRes = R.string.lbl_today_route_title
    )

    data object History : NavDestination(
        route = "history_route",
        stringRes = R.string.lbl_history_route_title
    )

    data object Settings : NavDestination(
        route = "settings_route",
        stringRes = R.string.lbl_settings_route_title
    )

    data object Units : NavDestination(
        route = "units_route",
        stringRes = R.string.lbl_units_route_title
    )

    data object DailyGoal : NavDestination(
        route = "daily_goal_route",
        stringRes = R.string.lbl_daily_goal
    )

    data object Container1 : NavDestination(
        route = "container_1_route",
        stringRes = R.string.lbl_container_1
    )

    data object Container2 : NavDestination(
        route = "container_2_route",
        stringRes = R.string.lbl_container_2
    )

    data object Container3 : NavDestination(
        route = "container_3_route",
        stringRes = R.string.lbl_container_3
    )

    companion object {
        fun getDestinationByRoute(route: String) = when (route) {
            "today_route" -> Today
            "history_route" -> History
            "settings_route" -> Settings
            "units_route" -> Units
            "daily_goal_route" -> DailyGoal
            "container_1_route" -> Container1
            "container_2_route" -> Container2
            else -> Container3
        }
    }
}
