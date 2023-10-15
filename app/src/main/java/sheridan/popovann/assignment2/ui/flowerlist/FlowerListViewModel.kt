package sheridan.popovann.assignment2.ui.flowerlist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import sheridan.popovann.assignment2.data.local.flowerList
import sheridan.popovann.assignment2.data.repository.FlowerDataRepository
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class FlowerListViewModel @Inject constructor(
    private val repository: FlowerDataRepository
) : ViewModel() {
    private val _uiState: MutableState<FlowerListUiState> =
        mutableStateOf(FlowerListUiState.Loaded(flowerList))
    val uiState: State<FlowerListUiState> = _uiState

    init {
        loadFlowerList()
    }

    private fun loadFlowerList() = viewModelScope.launch {
        //fake loading delay, 2 seconds
        delay(2000)
        try {
            val pets = repository.getAllFlowers()
            _uiState.value = FlowerListUiState.Loaded(pets)
        } catch (e: IOException) {
            _uiState.value = FlowerListUiState.Error
            e.printStackTrace()
        }
    }

    fun reloadFlowerList() {
        _uiState.value = FlowerListUiState.Loading
        loadFlowerList()
    }
}