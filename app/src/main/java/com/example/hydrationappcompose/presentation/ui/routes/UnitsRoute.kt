package com.example.hydrationappcompose.presentation.ui.routes

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.hydrationappcompose.R
import com.example.hydrationappcompose.model.MeasurementUnit
import com.example.hydrationappcompose.presentation.theme.HydrationAppTheme
import com.example.hydrationappcompose.presentation.ui.viewmodel.UnitsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UnitsRoute() {
    val unitsViewModel = koinViewModel<UnitsViewModel>()
    val uiState by unitsViewModel.uiState.collectAsStateWithLifecycle()
    val (millilitersItemColor, ouncesItemColor) = when (MeasurementUnit.getById(uiState.unitId)) {
        MeasurementUnit.MILLILITERS -> MaterialTheme.colorScheme.primary to MaterialTheme.colorScheme.onSurface
        MeasurementUnit.OUNCES -> MaterialTheme.colorScheme.onSurface to MaterialTheme.colorScheme.primary
    }

    Column(modifier = Modifier.padding(top = 40.dp)) {
        ListItem(
            modifier = Modifier.clickable {
                unitsViewModel.onSelectUnit(MeasurementUnit.MILLILITERS.id)
            },
            headlineContent = {
                Text(
                    text = stringResource(R.string.lbl_unit_milliliters),
                    color = millilitersItemColor
                )
            }
        )

        ListItem(
            modifier = Modifier.clickable {
                unitsViewModel.onSelectUnit(MeasurementUnit.OUNCES.id)
            },
            headlineContent = {
                Text(
                    text = stringResource(R.string.lbl_unit_ounces),
                    color = ouncesItemColor
                )
            }
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun UnitsRoutePreview() {
    HydrationAppTheme {
        UnitsRoute()
    }
}
