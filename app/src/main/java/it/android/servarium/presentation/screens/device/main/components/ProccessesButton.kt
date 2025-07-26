package it.android.servarium.presentation.screens.device.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import it.android.servarium.R
import it.android.servarium.presentation.ui.theme.outlineVariantDark

// Процессы кнопка компонент
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProcessesButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        border = BorderStroke(1.dp, outlineVariantDark),
        modifier = modifier
            .size(width = 185.dp, height = 180.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row {
            Box(

                modifier = Modifier
                    .width(5.dp)
                    .fillMaxHeight()
                    .background(CategoryColors.PROCESSES)

            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_terminal),
                    contentDescription = null,
                    tint = CategoryColors.PROCESSES,
                    modifier = Modifier.size(48.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = stringResource(R.string.metrics_card_label_processes),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}