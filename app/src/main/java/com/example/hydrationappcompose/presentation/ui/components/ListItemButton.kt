package com.example.hydrationappcompose.presentation.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hydrationappcompose.presentation.theme.HydrationAppTheme

@Composable
fun ListItemButton(
    title: String,
    onClick: () -> Unit,
    primaryTrailingText: String,
    modifier: Modifier = Modifier,
    secondaryTrailingText: String? = null
) {
    Surface(modifier = modifier.clickable { onClick() }) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = title,
                modifier = Modifier.weight(1f)
            )

            Text(
                text = primaryTrailingText,
                color = MaterialTheme.colorScheme.primary
            )

            secondaryTrailingText?.let { Text(text = it) }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ListItemButtonPreview() {
    HydrationAppTheme {
        ListItemButton(
            title = "Title",
            onClick = { },
            primaryTrailingText = "2000",
            secondaryTrailingText = "ml"
        )
    }
}
