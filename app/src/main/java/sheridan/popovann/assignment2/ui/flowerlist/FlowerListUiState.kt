package sheridan.popovann.assignment2.ui.flowerlist

import sheridan.popovann.assignment2.domain.Flower

sealed interface FlowerListUiState {
    data class Loaded(val flowers: List<Flower>):FlowerListUiState
}