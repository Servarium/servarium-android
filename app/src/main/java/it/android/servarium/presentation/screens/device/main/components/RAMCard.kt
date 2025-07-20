package it.android.servarium.presentation.screens.device.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import it.android.servarium.R
import it.android.servarium.presentation.ui.theme.outlineVariantDark

// Data класс для RAM данных
data class RAMData(
    val usage: Int,
    val totalGB: Int
)

// RAM карточка компонент
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RAMCard(
    data: RAMData,
    modifier: Modifier = Modifier
) {
    Card(
        border = BorderStroke(1.dp, outlineVariantDark),
        modifier = modifier
            .size(width = 185.dp, height = 180.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row {
            // Цветная полоска слева
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .fillMaxHeight()
                    .background(CategoryColors.RAM)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(contentAlignment = Alignment.Center) {
                    SemiCircularProgressIndicator(
                        percentage = data.usage,
                        color = CategoryColors.RAM,
                        size = 70.dp,
                        strokeWidth = 4.dp
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_memory_stick),
                            contentDescription = "RAM",
                            tint = CategoryColors.RAM,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "${data.usage}%",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "RAM",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = "Всего ${data.totalGB} ГБ",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}