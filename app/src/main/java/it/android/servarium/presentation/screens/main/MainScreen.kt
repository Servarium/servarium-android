package it.android.servarium.presentation.screens.main

import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.android.servarium.R
import it.android.servarium.presentation.ui.theme.ServariumTheme

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
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                // Добавляем отступ сверху для статус-бара
                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {  }) {

                    }
                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "Servarium",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Navigate",
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(pcs ?: emptyList()) { pc ->
                        PcCard(
                            pc = pc,
                            onClick = { onPcClick(pc.id) },
                            onDelete = { onDeleteClick(pc.id) }
                        )
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = {  },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = "Add PC",
                modifier = Modifier.size(24.dp)
            )
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