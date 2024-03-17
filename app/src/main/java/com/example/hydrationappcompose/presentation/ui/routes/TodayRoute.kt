package com.example.hydrationappcompose.presentation.ui.routes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.hydrationappcompose.R
import com.example.hydrationappcompose.presentation.ui.components.LoadingScreen
import com.example.hydrationappcompose.presentation.ui.components.TodayScreen
import com.example.hydrationappcompose.presentation.ui.viewmodel.TodayViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun TodayRoute() {
    val todayViewModel = koinViewModel<TodayViewModel>()
    val uiState by todayViewModel.uiState.collectAsStateWithLifecycle()

    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.leaf_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        TodayScreen(
            uiState = uiState,
            onContainer1Click = { },
            onContainer2Click = { },
            onContainer3Click = { },
        )

        AnimatedVisibility(
            visible = uiState.isLoading,
            exit = fadeOut(animationSpec = tween(300)),
            content = { LoadingScreen() }
        )
    }
}
