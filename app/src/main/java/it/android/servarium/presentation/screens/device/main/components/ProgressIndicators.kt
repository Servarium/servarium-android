package it.android.servarium.presentation.screens.device.main.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun SemiCircularProgressIndicator(
    percentage: Int,
    color: Color,
    modifier: Modifier = Modifier,
    size: androidx.compose.ui.unit.Dp = 80.dp,
    strokeWidth: androidx.compose.ui.unit.Dp = 6.dp
) {
    Canvas(
        modifier = modifier.size(size)
    ) {
        val canvasSize = size.toPx()
        val radius = (canvasSize - strokeWidth.toPx()) / 2
        val center = canvasSize / 2

        drawArc(
            color = Color.Gray.copy(alpha = 0.3f),
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = false,
            style = Stroke(strokeWidth.toPx()),
            topLeft = androidx.compose.ui.geometry.Offset(
                center - radius,
                center - radius
            ),
            size = androidx.compose.ui.geometry.Size(radius * 2, radius * 2)
        )

        val sweepAngle = (percentage / 100f) * 180f
        drawArc(
            color = color,
            startAngle = 180f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(
                width = strokeWidth.toPx(),
                cap = androidx.compose.ui.graphics.StrokeCap.Round
            ),
            topLeft = androidx.compose.ui.geometry.Offset(
                center - radius,
                center - radius
            ),
            size = androidx.compose.ui.geometry.Size(radius * 2, radius * 2)
        )
    }
}

@Composable
fun LinearProgressIndicator(
    percentage: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(6.dp)
            .background(
                Color.Gray.copy(alpha = 0.3f),
                RoundedCornerShape(3.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(percentage / 100f)
                .fillMaxHeight()
                .background(
                    color,
                    RoundedCornerShape(3.dp)
                )
        )
    }
}