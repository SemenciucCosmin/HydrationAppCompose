package com.example.hydrationappcompose.presentation.ui.routes

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.hydrationappcompose.R
import com.example.hydrationappcompose.domain.model.MeasurementUnit
import com.example.hydrationappcompose.navigation.LocalNavController
import com.example.hydrationappcompose.navigation.NavDestination
import com.example.hydrationappcompose.presentation.theme.HydrationAppTheme
import com.example.hydrationappcompose.presentation.ui.components.ListItemButton
import com.example.hydrationappcompose.presentation.ui.viewmodel.SettingsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsRoute() {
    val navController = LocalNavController.current
    val settingsViewModel = koinViewModel<SettingsViewModel>()
    val uiState by settingsViewModel.uiState.collectAsStateWithLifecycle()
    val unit = MeasurementUnit.getById(uiState.unitId)

    Column {
        Spacer(modifier = Modifier.height(40.dp))

        HorizontalDivider()

        ListItemButton(
            title = stringResource(R.string.lbl_units_route_title),
            onClick = { navController.navigate(NavDestination.Units.route) },
            primaryTrailingText = stringResource(unit.shortStringRes)
        )

        HorizontalDivider()

        ListItemButton(
            title = stringResource(R.string.lbl_daily_goal),
            onClick = { navController.navigate(NavDestination.DailyGoal.route) },
            primaryTrailingText = uiState.dailyGoal.toString(),
            secondaryTrailingText = stringResource(unit.shortStringRes)
        )

        HorizontalDivider()

        Spacer(modifier = Modifier.height(70.dp))

        Text(
            text = stringResource(R.string.lbl_containers),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        HorizontalDivider()

        ListItemButton(
            title = stringResource(R.string.lbl_container_1),
            onClick = { navController.navigate(NavDestination.Container1.route) },
            primaryTrailingText = uiState.container1Size.toString(),
            secondaryTrailingText = stringResource(unit.shortStringRes)
        )

        HorizontalDivider()

        ListItemButton(
            title = stringResource(R.string.lbl_container_2),
            onClick = { navController.navigate(NavDestination.Container2.route) },
            primaryTrailingText = uiState.container2Size.toString(),
            secondaryTrailingText = stringResource(unit.shortStringRes)
        )

        HorizontalDivider()

        ListItemButton(
            title = stringResource(R.string.lbl_container_3),
            onClick = { navController.navigate(NavDestination.Container3.route) },
            primaryTrailingText = uiState.container3Size.toString(),
            secondaryTrailingText = stringResource(unit.shortStringRes)
        )

        HorizontalDivider()

        Text(
            text = stringResource(R.string.lbl_container_route_message),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SettingsRoutePreview() {
    HydrationAppTheme {
        SettingsRoute()
    }
}
