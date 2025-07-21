package it.android.servarium.presentation.screens.auth.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import it.android.servarium.R

@Composable
fun PasswordTextField(
    labelTextId: Int = R.string.password_text_field,
    imeAction: ImeAction = ImeAction.Done
) {
    val value = remember { mutableStateOf("") }
    var valueVisible by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),

        label = { Text(stringResource(labelTextId)) },
        shape = MaterialTheme.shapes.small,

        value = value.value,
        onValueChange = { value.value = it },

        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus() }
        ),

        visualTransformation =
            if (valueVisible) VisualTransformation.None
            else PasswordVisualTransformation(),
        trailingIcon = {
            val vector =
                if (valueVisible) R.drawable.ic_eye_off
                else R.drawable.ic_eye

            val content =
                if (valueVisible) R.string.hide_password_description
                else R.string.show_password_description

            IconButton(onClick = { valueVisible = !valueVisible }) {
                Icon(
                    imageVector = ImageVector.vectorResource(vector),
                    contentDescription = stringResource(content)
                )
            }
        }
    )
}