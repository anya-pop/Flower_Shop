package sheridan.popovann.flowershop.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(
        topStart = 15.dp,  // Top left
        topEnd = 15.dp,    // Top right
        bottomEnd = 15.dp, // Bottom right
        bottomStart = 50.dp // Bottom left
    ),
    medium = RoundedCornerShape(
        topStart = 15.dp,  // Top left
        topEnd = 50.dp,    // Top right
        bottomEnd = 15.dp, // Bottom right
        bottomStart = 50.dp // Bottom left
    )
)