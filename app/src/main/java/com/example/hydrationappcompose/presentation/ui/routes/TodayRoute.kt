package com.example.hydrationappcompose.presentation.ui.routes

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.hydrationappcompose.model.MeasurementUnit
import com.example.hydrationappcompose.presentation.theme.HydrationAppTheme
import com.example.hydrationappcompose.presentation.ui.components.ContainerButtonsRow

private const val BACKGROUND_CONSTRAINT = "background"
private const val PERCENTAGE_CONSTRAINT = "percentage"
private const val GOAL_CONSTRAINT = "goal"
private const val CONTAINER_CONSTRAINT = "container"
private const val INTAKE_CONSTRAINT = "intake"
private const val BUTTONS_CONSTRAINT = "buttons"
private const val MESSAGE_CONSTRAINT = "message"

@Composable
fun TodayRoute() {
    ConstraintLayout(
        constraintSet = constraintSet(),
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.layoutId(BACKGROUND_CONSTRAINT),
            painter = painterResource(R.drawable.leaf_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text(
            text = stringResource(R.string.lbl_percentage_formatted),
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .layoutId(PERCENTAGE_CONSTRAINT)
                .padding(horizontal = 16.dp)
        )

        Text(
            text = stringResource(R.string.lbl_goal_message_formatted),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
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
            text = stringResource(R.string.lbl_unit_formatted_ml),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            modifier = Modifier
                .layoutId(INTAKE_CONSTRAINT)
                .padding(8.dp)
        )

        ContainerButtonsRow(
            unit = MeasurementUnit.MILLILITERS,
            container1Size = 100,
            container2Size = 250,
            container3Size = 750,
            onContainer1Click = { /*TODO*/ },
            onContainer2Click = { /*TODO*/ },
            onContainer3Click = { /*TODO*/ },
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
    val background = createRefFor(BACKGROUND_CONSTRAINT)
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

    constrain(background) {
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        top.linkTo(parent.top)
        bottom.linkTo(parent.bottom)
    }

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
private fun TodayRoutePreview() {
    HydrationAppTheme {
        TodayRoute()
    }
}
