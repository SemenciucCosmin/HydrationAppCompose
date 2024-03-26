package com.example.hydrationappcompose.presentation.ui.routes

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.hydrationappcompose.R
import com.example.hydrationappcompose.domain.model.Container
import com.example.hydrationappcompose.domain.model.MeasurementUnit
import com.example.hydrationappcompose.presentation.theme.HydrationAppTheme
import com.example.hydrationappcompose.presentation.ui.components.ContainerSizeTextField
import com.example.hydrationappcompose.presentation.ui.viewmodel.ContainerViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ContainerRoute(container: Container) {
    val containerViewModel = koinViewModel<ContainerViewModel>()
    val uiState by containerViewModel.uiState.collectAsStateWithLifecycle()
    val unit = MeasurementUnit.getById(uiState.unitId)
    var containerSize by remember {
        mutableStateOf(
            when (container) {
                Container.DAILY_GOAL -> uiState.dailyGoal.toString()
                Container.CONTAINER_1 -> uiState.container1Size.toString()
                Container.CONTAINER_2 -> uiState.container2Size.toString()
                Container.CONTAINER_3 -> uiState.container3Size.toString()
            }
        )
    }
    val isError = containerSize.toFloatOrNull() == null && containerSize.isNotBlank()

    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.leaf_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(container.messageRes),
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(
                    bottom = 100.dp,
                    top = 40.dp
                )
            )

            ContainerSizeTextField(
                value = containerSize,
                isError = isError,
                onValueChanged = { containerSize = it },
                onDone = {
                    if (!isError) {
                        containerViewModel.saveContainerSize(containerSize.toFloat(), container)
                    }
                }
            )

            Text(
                text = stringResource(unit.detailedStringRes),
                color = Color.White,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ContainerRoutePreview() {
    HydrationAppTheme {
        ContainerRoute(Container.DAILY_GOAL)
    }
}
