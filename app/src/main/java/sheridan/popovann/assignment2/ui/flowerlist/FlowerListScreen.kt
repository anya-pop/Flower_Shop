package sheridan.popovann.assignment2.ui.flowerlist

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import sheridan.popovann.assignment2.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowerListScreen(
    viewModel: FlowerListViewModel,
    modifier: Modifier = Modifier
){
    val state: State<FlowerListUiState> = viewModel.uiState
    val uiState: FlowerListUiState = state.value

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = stringResource(R.string.list_title),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior,

            )
        }
    ) { innerPadding ->
        when (uiState) {
            is FlowerListUiState.Loaded -> ListBody(
                flowerList = uiState.flowers,
                modifier = modifier.padding(innerPadding)
            )
            is FlowerListUiState.Loading -> LoadingBody()
            is FlowerListUiState.Error -> ErrorBody(
                onRetry = viewModel::reloadFlowerList
            )
        }
    }
}
