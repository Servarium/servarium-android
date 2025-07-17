package it.android.servarium.presentation.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.android.servarium.R
import it.android.servarium.presentation.ui.theme.ServariumTheme

@Composable
fun PcCard(
    pc: PC,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onDelete: () -> Unit
) {
    Box(modifier = modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() },
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(12.dp)
            ) {
                Image(
                    painter = painterResource(id = pc.imageRes),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )
                Spacer(Modifier.width(12.dp))
                Column(Modifier.weight(1f)) {
                    Text(pc.name, style = MaterialTheme.typography.titleMedium)
                    Text(pc.os, style = MaterialTheme.typography.bodySmall)
                }
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(
                            color = if (pc.isOnline)
                                MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.error
                        )
                )
            }
        }

        IconButton(
            onClick = onDelete,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 4.dp)
        ) {

        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewPcCard() {
    val testPc = PC(
        id = 1,
        name = "Potato PC",
        os = "Kubuntu 21.10",
        imageRes = R.drawable.ubuntu,
        isOnline = true
    )

    ServariumTheme {
        PcCard(
            pc = testPc,
            onClick = {},
            onDelete = {}
        )
    }
}
