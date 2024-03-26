package com.example.hydrationappcompose.presentation.ui.routes

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hydrationappcompose.R
import com.example.hydrationappcompose.domain.model.MeasurementUnit
import com.example.hydrationappcompose.presentation.theme.HydrationAppTheme
import com.example.hydrationappcompose.presentation.ui.viewmodel.UnitsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UnitsRoute() {
    val unitsViewModel = koinViewModel<UnitsViewModel>()
    val unit = MeasurementUnit.getById(unitsViewModel.unitId)
    val selectedUnitColor = MaterialTheme.colorScheme.primary
    val unselectedUnitColor = MaterialTheme.colorScheme.onSurface
    val (millilitersItemColor, ouncesItemColor) = when (unit) {
        MeasurementUnit.MILLILITERS -> selectedUnitColor to unselectedUnitColor
        MeasurementUnit.OUNCES -> unselectedUnitColor to selectedUnitColor
    }

    Column(modifier = Modifier.padding(top = 40.dp)) {
        ListItem(
            modifier = Modifier.clickable {
                unitsViewModel.selectUnit(MeasurementUnit.MILLILITERS.id)
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
                unitsViewModel.selectUnit(MeasurementUnit.OUNCES.id)
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
