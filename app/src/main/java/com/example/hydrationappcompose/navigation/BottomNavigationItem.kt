package com.example.hydrationappcompose.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.hydrationappcompose.R

data class BottomNavigationItem(
    val route: String,
    @StringRes val stringRes: Int,
    @DrawableRes val drawableRes: Int
)

val bottomNavigationItems = listOf(
    BottomNavigationItem(
        route = NavDestination.Today.route,
        stringRes = R.string.lbl_today,
        drawableRes = R.drawable.ic_today
    ),
    BottomNavigationItem(
        route = NavDestination.History.route,
        stringRes = R.string.lbl_history,
        drawableRes = R.drawable.ic_history
    )
)
