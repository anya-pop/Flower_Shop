package sheridan.popovann.flowershop.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import sheridan.popovann.flowershop.ui.flowerlist.FlowerListViewModel
import sheridan.popovann.flowershop.ui.flowerlist.FlowerListScreen
@Composable
fun AppScreen() {
    val viewModel: FlowerListViewModel = viewModel()
    FlowerListScreen(viewModel)
}
