package it.android.servarium.presentation.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.android.servarium.R
import it.android.servarium.data.PC
import it.android.servarium.presentation.screens.main.components.CustomSnackbarWithTimer
import it.android.servarium.presentation.screens.main.components.PcCard
import it.android.servarium.presentation.screens.main.components.TopBar
import it.android.servarium.presentation.ui.theme.ServariumTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onPcClick: (pcId: Int) -> Unit,
    onDeleteClick: (pcId: Int) -> Unit = {},
    pcs: List<PC>? = null,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    var deletedPcIds by remember { mutableStateOf(setOf<Int>()) }
    var pendingDeleteId by remember { mutableStateOf<Int?>(null) }

    fun showUndoSnackbar(pcId: Int, pcName: String) {
        pendingDeleteId = pcId
        deletedPcIds = deletedPcIds + pcId
    }

    LaunchedEffect(pendingDeleteId) {
        pendingDeleteId?.let { pcId ->
            val pc = pcs?.find { it.id == pcId }
            if (pc != null) {
                val result = snackbarHostState.showSnackbar(
                    message = "${pc.name} удален",
                    actionLabel = "Отменить",
                    duration = SnackbarDuration.Short,
                    withDismissAction = false
                )

                when (result) {
                    SnackbarResult.ActionPerformed -> {
                        deletedPcIds = deletedPcIds - pcId
                        pendingDeleteId = null
                    }

                    SnackbarResult.Dismissed -> {
                        onDeleteClick(pcId)
                        deletedPcIds = deletedPcIds - pcId
                        pendingDeleteId = null
                    }
                }
            }
        }
    }

    Box(

        modifier = modifier.fillMaxSize()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {


            Column {
                Spacer(modifier = Modifier.height(50.dp))
                TopBar(

                )


                Spacer(modifier = Modifier.height(0.dp))


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
                            onDelete = { showUndoSnackbar(pc.id, pc.name) },
                            isDeleted = pc.id in deletedPcIds
                        )
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = { },
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

        SnackbarHost(
            hostState = snackbarHostState,
            snackbar = { data -> CustomSnackbarWithTimer(data) },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
        )


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    val fakePcs = listOf(
        PC(1, "PC-1", "Ubuntu 24.04 LTS", R.drawable.logo_ubuntu, false),
        PC(2, "PC-2", "Debian 12.1", R.drawable.logo_debian, true),
        PC(3, "Potato pc 3", "Kubuntu 21.10", R.drawable.logo_ubuntu, false)
    )

    ServariumTheme {
        MainScreen(
            onPcClick = {},
            onDeleteClick = {},
            pcs = fakePcs
        )
        
    }
}