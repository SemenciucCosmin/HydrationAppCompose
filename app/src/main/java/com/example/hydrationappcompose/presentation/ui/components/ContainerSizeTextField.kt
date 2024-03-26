package com.example.hydrationappcompose.presentation.ui.components

import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.hydrationappcompose.R
import com.example.hydrationappcompose.common.Defaults
import com.example.hydrationappcompose.presentation.theme.HydrationAppTheme

@Composable
fun ContainerSizeTextField(
    value: String,
    isError: Boolean,
    onValueChanged: (String) -> Unit,
    onDone: () -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        textStyle = MaterialTheme.typography.bodyLarge.copy(textAlign = TextAlign.Center),
        isError = isError,
        singleLine = true,
        shape = MaterialTheme.shapes.medium,
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                focusManager.clearFocus()
                onDone()
            }
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        supportingText = {
            if (isError) {
                Text(text = stringResource(R.string.lbl_container_text_field_error_message))
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = Color.White,
            errorTextColor = Color.White,
            errorSupportingTextColor = MaterialTheme.colorScheme.error,
            errorBorderColor = MaterialTheme.colorScheme.error
        ),
        modifier = Modifier
            .widthIn(1.dp, Dp.Infinity)
            .focusRequester(focusRequester),
    )
}

@Preview
@Composable
private fun ContainerSizeTextFieldPreview() {
    HydrationAppTheme {
        ContainerSizeTextField(
            value = Defaults.CONTAINER_1_SIZE.toString(),
            isError = false,
            onValueChanged = { },
            onDone = { }
        )
    }
}

@Preview
@Composable
private fun ContainerSizeTextFieldErrorPreview() {
    HydrationAppTheme {
        ContainerSizeTextField(
            value = Defaults.CONTAINER_1_SIZE.toString(),
            isError = true,
            onValueChanged = { },
            onDone = { }
        )
    }
}
