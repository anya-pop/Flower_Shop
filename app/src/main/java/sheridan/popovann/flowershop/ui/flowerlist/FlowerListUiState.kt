package sheridan.popovann.flowershop.ui.flowerlist

import sheridan.popovann.flowershop.domain.Flower

sealed interface FlowerListUiState {
    data class Loaded(val flowers: List<Flower>):FlowerListUiState
    object Loading: FlowerListUiState
    object Error: FlowerListUiState
}