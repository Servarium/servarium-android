package it.android.servarium.presentation.screens.login


import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.android.servarium.R
import it.android.servarium.presentation.ui.theme.ServariumTheme

@Composable
fun AuthScreen(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {

        Column(
            modifier = Modifier.wrapContentSize()
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Box(
                modifier = Modifier
                    .size(300.dp)
                    .clip(RoundedCornerShape(45.dp))
                    .background(MaterialTheme.colorScheme.primary),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_app),
                    contentDescription = stringResource(R.string.app_logo_description),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
        }

        Column(
            modifier = Modifier.width(300.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
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

            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text(stringResource(R.string.password_text_field)) },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ),
                shape = MaterialTheme.shapes.small,
                visualTransformation =
                    if (passwordVisible) VisualTransformation.None
                    else PasswordVisualTransformation(),
                trailingIcon = {
                    val vector =
                        if (passwordVisible) R.drawable.ic_eye_off
                        else R.drawable.ic_eye

                    val content =
                        if (passwordVisible) R.string.hide_password_description
                        else R.string.show_password_description

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(vector),
                            contentDescription = stringResource(content)
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onLoginClick,
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(R.string.login),
                    fontSize = 16.sp
                )
            }

            OutlinedButton(
                onClick = onRegisterClick,
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(R.string.registration),
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(18.dp))
        }
    }
}

@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun PreviewAuthScreen() {
    ServariumTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.surfaceContainerLowest
        ) {
            AuthScreen(
                modifier = Modifier
                    .safeDrawingPadding()
                    .fillMaxSize(),
                onLoginClick = {},
                onRegisterClick = {}
            )
        }
    }
}