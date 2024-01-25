package sheridan.popovann.flowershop.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sheridan.popovann.flowershop.data.local.flowerList
import sheridan.popovann.flowershop.domain.Flower
import javax.inject.Inject

class FakeFlowerDataRepository @Inject constructor(): FlowerDataRepository {

    override suspend fun getAllFlowers(): List<Flower> =
        withContext(Dispatchers.IO) {
            flowerList
        }
}