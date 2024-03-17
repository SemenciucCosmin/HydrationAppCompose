package com.example.hydrationappcompose.presentation.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hydrationappcompose.R
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen() {
    val drawableFrames = getDrawableFrameList()
    var currentDrawableFrameIndex by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(20)
            currentDrawableFrameIndex = (currentDrawableFrameIndex + 1) % drawableFrames.count()
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background.copy(alpha = 0.8f))
    ) {
        Icon(
            painter = painterResource(drawableFrames[currentDrawableFrameIndex]),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(150.dp)
        )

        Text(
            text = stringResource(R.string.lbl_loading),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

private fun getDrawableFrameList() = listOf(
    R.drawable.ic_glass_00,
    R.drawable.ic_glass_01,
    R.drawable.ic_glass_02,
    R.drawable.ic_glass_03,
    R.drawable.ic_glass_04,
    R.drawable.ic_glass_05,
    R.drawable.ic_glass_06,
    R.drawable.ic_glass_07,
    R.drawable.ic_glass_08,
    R.drawable.ic_glass_09,
    R.drawable.ic_glass_10,
    R.drawable.ic_glass_11,
    R.drawable.ic_glass_12,
    R.drawable.ic_glass_13,
    R.drawable.ic_glass_14,
    R.drawable.ic_glass_15,
    R.drawable.ic_glass_16,
    R.drawable.ic_glass_17,
    R.drawable.ic_glass_18,
    R.drawable.ic_glass_19,
    R.drawable.ic_glass_20,
    R.drawable.ic_glass_21,
    R.drawable.ic_glass_22,
    R.drawable.ic_glass_23,
    R.drawable.ic_glass_24,
    R.drawable.ic_glass_25,
    R.drawable.ic_glass_26,
    R.drawable.ic_glass_27,
    R.drawable.ic_glass_28,
    R.drawable.ic_glass_29,
    R.drawable.ic_glass_30,
    R.drawable.ic_glass_31,
    R.drawable.ic_glass_32,
    R.drawable.ic_glass_33,
    R.drawable.ic_glass_34,
    R.drawable.ic_glass_35,
    R.drawable.ic_glass_36,
    R.drawable.ic_glass_37,
    R.drawable.ic_glass_38,
    R.drawable.ic_glass_39,
    R.drawable.ic_glass_40,
    R.drawable.ic_glass_41,
    R.drawable.ic_glass_42,
    R.drawable.ic_glass_43,
    R.drawable.ic_glass_44,
    R.drawable.ic_glass_45,
)

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoadingScreenPreview() {
    MaterialTheme {
        LoadingScreen()
    }
}
