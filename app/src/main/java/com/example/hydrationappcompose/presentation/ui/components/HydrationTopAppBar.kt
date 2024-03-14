package com.example.hydrationappcompose.presentation.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hydrationappcompose.R
import com.example.hydrationappcompose.presentation.theme.HydrationAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HydrationTopAppBar(
    title: String,
    showActionIcon: Boolean,
    showNavigationIcon: Boolean,
    onActionIconClick: () -> Unit = { },
    onNavigationIconClick: () -> Unit = { }
) {
    Column {
        CenterAlignedTopAppBar(
            title = { Text(text = title) },
            navigationIcon = {
                if (showNavigationIcon) {
                    IconButton(onClick = onNavigationIconClick) {
                        Icon(
                            painter = painterResource(R.drawable.ic_back),
                            contentDescription = stringResource(R.string.lbl_back)
                        )
                    }
                }
            },
            actions = {
                if (showActionIcon) {
                    IconButton(onClick = onActionIconClick) {
                        Icon(
                            painter = painterResource(R.drawable.ic_settings),
                            contentDescription = stringResource(R.string.lbl_settings_route_title)
                        )
                    }
                }
            }
        )

        HorizontalDivider(color = MaterialTheme.colorScheme.primary)
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HydrationTopAppBarPreview() {
    HydrationAppTheme {
        HydrationTopAppBar(
            title = "Title",
            showActionIcon = true,
            showNavigationIcon = true,
        )
    }
}
