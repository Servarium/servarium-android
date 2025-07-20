package it.android.servarium.presentation.screens.device.main.components


import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.android.servarium.R
import it.android.servarium.presentation.screens.device.main.DeviceMainScreen
import it.android.servarium.presentation.ui.theme.ServariumTheme
import it.android.servarium.presentation.ui.theme.outlineVariantDark

// Цвета для категорий
object CategoryColors {
    val CPU = Color(0xFFEF4444)
    val RAM = Color(0xFFA855F7)
    val DISK = Color(0xFFF97316)
    val NETWORK = Color(0xFF3B82F6)
    val DOCKER = Color(0xFF3B82F6)
    val PROCESSES = Color(0xFF8F8F8F)
}

// Data класс для CPU данных
data class CPUData(
    val usage: Int,
    val temperature: Int
)

// CPU карточка компонент
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CPUCard(
    data: CPUData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .size(width = 185.dp, height = 180.dp),
        border = BorderStroke(1.dp, outlineVariantDark),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface, ),
        shape = RoundedCornerShape(12.dp),

    ) {
        Row {
            // Цветная полоска слева
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .fillMaxHeight()
                    .background(CategoryColors.CPU)
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
                        color = CategoryColors.CPU,
                        size = 70.dp,
                        strokeWidth = 4.dp
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_zap),
                            contentDescription = "CPU",
                            tint = CategoryColors.CPU,
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
                    text = "CPU",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = "Температура ${data.temperature}°C",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DeviceMainScreenPreview() {
    ServariumTheme {
        Scaffold { innerPadding ->

            CPUCard(
                CPUData(70, 80)
            )
        }
    }
}