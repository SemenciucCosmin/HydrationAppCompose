package com.example.hydrationappcompose.presentation.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hydrationappcompose.common.Defaults
import com.example.hydrationappcompose.domain.model.MeasurementUnit
import com.example.hydrationappcompose.presentation.theme.HydrationAppTheme

@Composable
fun ContainerButtonsRow(
    unit: MeasurementUnit,
    container1Size: Float,
    container2Size: Float,
    container3Size: Float,
    onContainer1Click: () -> Unit,
    onContainer2Click: () -> Unit,
    onContainer3Click: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        modifier = modifier.fillMaxWidth()
    ) {
        Button(
            onClick = onContainer1Click,
            shape = MaterialTheme.shapes.small
        ) {
            Text(text = stringResource(unit.formattedStringRes, container1Size))
        }

        Button(
            onClick = onContainer2Click,
            shape = MaterialTheme.shapes.small
        ) {
            Text(text = stringResource(unit.formattedStringRes, container2Size))
        }

        Button(
            onClick = onContainer3Click,
            shape = MaterialTheme.shapes.small
        ) {
            Text(text = stringResource(unit.formattedStringRes, container3Size))
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ContainerButtonsRowPreview() {
    HydrationAppTheme {
        ContainerButtonsRow(
            unit = MeasurementUnit.MILLILITERS,
            container1Size = Defaults.CONTAINER_1_SIZE,
            container2Size = Defaults.CONTAINER_2_SIZE,
            container3Size = Defaults.CONTAINER_3_SIZE,
            onContainer1Click = { },
            onContainer2Click = { },
            onContainer3Click = { }
        )
    }
}
