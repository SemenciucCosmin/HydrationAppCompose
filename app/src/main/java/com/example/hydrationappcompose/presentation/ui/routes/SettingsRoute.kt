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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hydrationappcompose.R
import com.example.hydrationappcompose.presentation.theme.HydrationAppTheme
import com.example.hydrationappcompose.presentation.ui.components.ListItemButton

@Composable
fun SettingsRoute() {
    Column {
        Spacer(modifier = Modifier.height(40.dp))

        HorizontalDivider()

        ListItemButton(
            title = stringResource(R.string.lbl_units_route_title),
            onClick = { },
            primaryTrailingText = ""
        )

        HorizontalDivider()

        ListItemButton(
            title = stringResource(R.string.lbl_daily_goal),
            onClick = { },
            primaryTrailingText = ""
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
            onClick = { },
            primaryTrailingText = ""
        )

        HorizontalDivider()

        ListItemButton(
            title = stringResource(R.string.lbl_container_2),
            onClick = { },
            primaryTrailingText = ""
        )

        HorizontalDivider()

        ListItemButton(
            title = stringResource(R.string.lbl_container_3),
            onClick = { },
            primaryTrailingText = ""
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
