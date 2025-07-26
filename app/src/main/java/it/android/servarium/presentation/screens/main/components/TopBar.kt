package it.android.servarium.presentation.screens.main.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.android.servarium.R

@Composable
fun TopBar(
    title: String = "PC-1",
    onBackClick: (pcId: Int) -> Unit = {},
    onInfoClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onInfoClick) {

        }
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = onInfoClick) {
            Icon(
                painter = painterResource(R.drawable.ic_log_out),
                contentDescription = "Info",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}