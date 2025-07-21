package it.android.servarium.presentation.screens.auth.registration


import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.android.servarium.R
import it.android.servarium.presentation.screens.auth.component.EmailTextField
import it.android.servarium.presentation.screens.auth.component.Logo
import it.android.servarium.presentation.screens.auth.component.PasswordTextField
import it.android.servarium.presentation.screens.auth.component.RemovableFocusBox
import it.android.servarium.presentation.ui.theme.ServariumTheme

@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier,
    onRegisterClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    RemovableFocusBox {
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
                Logo()
                Spacer(modifier = Modifier.height(30.dp))
            }

            Column(
                modifier = Modifier.width(300.dp),
                verticalArrangement = Arrangement.spacedBy(22.dp)
            ) {
                EmailTextField()
                PasswordTextField(imeAction = ImeAction.Next)
                PasswordTextField(labelTextId = R.string.repeat_password_text_field)

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = onRegisterClick,
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        text = stringResource(R.string.register),
                        fontSize = 16.sp
                    )
                }

                OutlinedButton(
                    onClick = onBackClick,
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(
                        text = stringResource(R.string.back),
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun PreviewRegisterScreen() {
    ServariumTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.surfaceContainerLowest
        ) {
            RegistrationScreen(
                modifier = Modifier
                    .safeDrawingPadding()
                    .fillMaxSize(),
                onBackClick = {},
            )
        }
    }
}
