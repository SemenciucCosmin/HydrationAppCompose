package com.example.hydrationappcompose.presentation.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.hydrationappcompose.R
import com.example.hydrationappcompose.domain.model.MeasurementUnit
import com.example.hydrationappcompose.presentation.theme.HydrationAppTheme
import com.example.hydrationappcompose.presentation.ui.viewmodel.model.TodayUiState

private const val PERCENTAGE_CONSTRAINT = "percentage"
private const val GOAL_CONSTRAINT = "goal"
private const val CONTAINER_CONSTRAINT = "container"
private const val INTAKE_CONSTRAINT = "intake"
private const val BUTTONS_CONSTRAINT = "buttons"
private const val MESSAGE_CONSTRAINT = "message"

@Composable
fun TodayScreen(
    uiState: TodayUiState,
    onContainer1Click: () -> Unit,
    onContainer2Click: () -> Unit,
    onContainer3Click: () -> Unit
) {
    val unit = MeasurementUnit.getById(uiState.unitId)

    ConstraintLayout(
        constraintSet = constraintSet(),
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.lbl_percentage_formatted, uiState.intake),
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .layoutId(PERCENTAGE_CONSTRAINT)
                .padding(horizontal = 16.dp)
        )

        Text(
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            text = stringResource(
                R.string.lbl_goal_message_formatted,
                uiState.dailyGoal,
                stringResource(unit.shortStringRes),
            ),
            modifier = Modifier
                .layoutId(GOAL_CONSTRAINT)
                .padding(16.dp),
        )

        Image(
            painter = painterResource(R.drawable.ic_glass_empty),
            contentDescription = null,
            modifier = Modifier.layoutId(CONTAINER_CONSTRAINT)
        )

        Text(
            text = stringResource(R.string.lbl_unit_formatted_ml, uiState.intake),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            modifier = Modifier
                .layoutId(INTAKE_CONSTRAINT)
                .padding(8.dp)
        )

        ContainerButtonsRow(
            unit = unit,
            container1Size = uiState.container1Size,
            container2Size = uiState.container2Size,
            container3Size = uiState.container3Size,
            onContainer1Click = onContainer1Click,
            onContainer2Click = onContainer2Click,
            onContainer3Click = onContainer3Click,
            modifier = Modifier
                .layoutId(BUTTONS_CONSTRAINT)
                .padding(top = 16.dp)
        )

        Text(
            text = stringResource(R.string.lbl_today_route_message),
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .layoutId(MESSAGE_CONSTRAINT)
                .padding(16.dp)
        )
    }
}

private fun constraintSet() = ConstraintSet {
    val percentage = createRefFor(PERCENTAGE_CONSTRAINT)
    val goal = createRefFor(GOAL_CONSTRAINT)
    val container = createRefFor(CONTAINER_CONSTRAINT)
    val intake = createRefFor(INTAKE_CONSTRAINT)
    val buttons = createRefFor(BUTTONS_CONSTRAINT)
    val message = createRefFor(MESSAGE_CONSTRAINT)

    createVerticalChain(
        percentage,
        goal,
        container,
        buttons,
        message,
        chainStyle = ChainStyle.Packed
    )

    constrain(percentage) {
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        top.linkTo(parent.top)
        bottom.linkTo(goal.top)
    }

    constrain(goal) {
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        top.linkTo(percentage.bottom)
        bottom.linkTo(container.top)
    }

    constrain(container) {
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        top.linkTo(goal.bottom)
        bottom.linkTo(buttons.top)
    }

    constrain(intake) {
        start.linkTo(container.start)
        end.linkTo(container.end)
        bottom.linkTo(container.bottom)
    }

    constrain(buttons) {
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        top.linkTo(container.bottom)
        bottom.linkTo(message.top)
    }

    constrain(message) {
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        top.linkTo(buttons.bottom)
        bottom.linkTo(parent.bottom)
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TodayScreenPreview() {
    HydrationAppTheme {
        TodayScreen(
            uiState = TodayUiState(),
            onContainer1Click = { },
            onContainer2Click = { },
            onContainer3Click = { }
        )
    }
}
