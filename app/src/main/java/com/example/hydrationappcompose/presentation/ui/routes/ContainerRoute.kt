package com.example.hydrationappcompose.presentation.ui.routes

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.hydrationappcompose.R
import com.example.hydrationappcompose.domain.model.Container
import com.example.hydrationappcompose.domain.model.MeasurementUnit
import com.example.hydrationappcompose.presentation.theme.HydrationAppTheme

private const val BACKGROUND_CONSTRAINT = "background"
private const val MESSAGE_CONSTRAINT = "message"
private const val TEXT_FIELD_CONSTRAINT = "text_field"
private const val UNIT_CONSTRAINT = "unit"

@Composable
fun ContainerRoute(container: Container) {
    var containerSize by remember { mutableStateOf("") }

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
            text = stringResource(container.messageRes),
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .layoutId(MESSAGE_CONSTRAINT)
                .padding(start = 16.dp, end = 16.dp, bottom = 100.dp, top = 40.dp)
        )

        OutlinedTextField(
            value = containerSize,
            onValueChange = { containerSize = it },
            textStyle = MaterialTheme.typography.bodyLarge,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            shape = MaterialTheme.shapes.medium,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.White,

                ),
            modifier = Modifier
                .layoutId(TEXT_FIELD_CONSTRAINT)
                .padding(horizontal = 16.dp),
        )

        Text(
            text = stringResource(MeasurementUnit.MILLILITERS.detailedStringRes),
            color = Color.White,
            modifier = Modifier
                .layoutId(UNIT_CONSTRAINT)
                .padding(top = 16.dp)
        )
    }
}

private fun constraintSet() = ConstraintSet {
    val background = createRefFor(BACKGROUND_CONSTRAINT)
    val message = createRefFor(MESSAGE_CONSTRAINT)
    val textField = createRefFor(TEXT_FIELD_CONSTRAINT)
    val unit = createRefFor(UNIT_CONSTRAINT)

    constrain(background) {
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        top.linkTo(parent.top)
        bottom.linkTo(parent.bottom)
    }

    constrain(message) {
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        top.linkTo(parent.top)
        bottom.linkTo(textField.top)
    }

    constrain(textField) {
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        top.linkTo(message.bottom)
        bottom.linkTo(unit.top)
    }

    constrain(unit) {
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        top.linkTo(textField.bottom)
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
