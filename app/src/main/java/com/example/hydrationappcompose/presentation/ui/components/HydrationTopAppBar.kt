package com.example.hydrationappcompose.presentation.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.hydrationappcompose.R
import com.example.hydrationappcompose.navigation.LocalNavController
import com.example.hydrationappcompose.navigation.NavigationDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HydrationTopAppBar(
    title: String,
    showActionIcon: Boolean,
    showNavigationIcon: Boolean
) {
    val navController = LocalNavController.current

    CenterAlignedTopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            if (showNavigationIcon) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_back),
                        contentDescription = stringResource(R.string.lbl_back)
                    )
                }
            }
        },
        actions = {
            if (showActionIcon) {
                IconButton(
                    onClick = {
                        navController.navigate(NavigationDestination.Settings.route)
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_settings),
                        contentDescription = stringResource(R.string.lbl_settings_route_title)
                    )
                }
            }
        }
    )
}
