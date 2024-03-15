package com.example.hydrationappcompose.presentation.ui.routes

import android.content.res.Configuration
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
import com.example.hydrationappcompose.model.MeasurementUnit
import com.example.hydrationappcompose.presentation.theme.HydrationAppTheme

@Composable
fun UnitsRoute() {
    val unit = MeasurementUnit.MILLILITERS
    val (millilitersItemColor, ouncesItemColor) = when (unit) {
        MeasurementUnit.MILLILITERS -> MaterialTheme.colorScheme.primary to MaterialTheme.colorScheme.onSurface
        MeasurementUnit.OUNCES -> MaterialTheme.colorScheme.onSurface to MaterialTheme.colorScheme.primary
    }

    Column(modifier = Modifier.padding(top = 40.dp)) {
        ListItem(
            headlineContent = {
                Text(
                    text = stringResource(R.string.lbl_unit_milliliters),
                    color = millilitersItemColor
                )
            }
        )

        ListItem(
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
