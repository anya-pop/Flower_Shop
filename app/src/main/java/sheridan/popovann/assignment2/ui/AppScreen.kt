package sheridan.popovann.assignment2.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import sheridan.popovann.assignment2.ui.flowerlist.FlowerListViewModel
import sheridan.popovann.assignment2.ui.flowerlist.FlowerListScreen
@Composable
fun AppScreen() {
    val viewModel: FlowerListViewModel = viewModel()
    FlowerListScreen(viewModel)
}
