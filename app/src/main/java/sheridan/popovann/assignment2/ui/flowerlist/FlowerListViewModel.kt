package sheridan.popovann.assignment2.ui.flowerlist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import sheridan.popovann.assignment2.data.local.flowerList

class FlowerListViewModel: ViewModel() {
    private val _uiState: MutableState<FlowerListUiState> =
        mutableStateOf(FlowerListUiState.Loaded(flowerList))
    val uiState: State<FlowerListUiState> = _uiState
}