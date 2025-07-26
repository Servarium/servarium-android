package it.android.servarium.presentation.screens.device.main

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.android.servarium.presentation.screens.device.main.components.*
import it.android.servarium.presentation.ui.theme.ServariumTheme

// Главный экран
@Composable
fun DeviceMainScreen(
    cpuData: CPUData = CPUData(70, 80),
    ramData: RAMData = RAMData(20, 16),
    diskData: DiskData = DiskData(74, 200, 300),
    networkData: NetworkData = NetworkData("192.168.4.60"),
    dockerData: DockerData = DockerData(5, 10),
    onProcessesClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    onInfoClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        TopBar(
            onBackClick = onBackClick,
            onInfoClick = onInfoClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CPUCard(data = cpuData)
                RAMCard(data = ramData)
            }

            DiskCard(data = diskData)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    NetworkCard(data = networkData)
                    DockerCard(data = dockerData)
                }
                ProcessesButton(onClick = onProcessesClick)
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES,
    backgroundColor = 0xFF000000
)
@Composable
fun DeviceMainScreenPreview() {
    ServariumTheme {
        Scaffold { innerPadding ->
            DeviceMainScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}