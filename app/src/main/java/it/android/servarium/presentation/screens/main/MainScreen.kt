package it.android.servarium.presentation.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import it.android.servarium.R
import it.android.servarium.presentation.ui.theme.ServariumTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.compose.runtime.getValue


data class PC(
    val id: Int,
    val name: String,
    val os: String,
    val imageRes: Int,
    val isOnline: Boolean
)

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onPcClick: (pcId: Int) -> Unit,
    onDeleteClick: (pcId: Int) -> Unit = {},
    pcs: List<PC>? = null,
) {

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Мои устройства",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.weight(2f),
                    textAlign = TextAlign.Center
                )
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Refresh",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                items(pcs ?: emptyList()) { pc ->
                    PcCard(
                        pc = pc,
                        onClick = { onPcClick(pc.id) },
                        onDelete = { onDeleteClick(pc.id) }
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                FloatingActionButton(
                    onClick = {  },
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add PC")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    val fakePcs = listOf(
        PC(1, "PC-1", "Ubuntu 24.04 LTS", R.drawable.ubuntu, false),
        PC(2, "PC-2", "Debian 12.1", R.drawable.ubuntu, true),
        PC(3, "Potato pc 3", "Kubuntu 21.10", R.drawable.ubuntu, false)
    )

    ServariumTheme {
        MainScreen(
            onPcClick = {},
            onDeleteClick = {},
            pcs = fakePcs
        )
    }
}
