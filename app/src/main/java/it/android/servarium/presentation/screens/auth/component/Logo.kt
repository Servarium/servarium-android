package it.android.servarium.presentation.screens.auth.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import it.android.servarium.R

@Composable
fun Logo() {
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
}