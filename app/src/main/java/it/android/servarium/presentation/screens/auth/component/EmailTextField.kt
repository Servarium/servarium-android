package it.android.servarium.presentation.screens.auth.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import it.android.servarium.R

@Composable
fun EmailTextField() {
    val email = remember { mutableStateOf("") }

    OutlinedTextField(
        value = email.value,
        onValueChange = { email.value = it },
        label = { Text(stringResource(R.string.email_text_field)) },
        shape = MaterialTheme.shapes.small,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    )
}