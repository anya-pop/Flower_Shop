package sheridan.popovann.assignment2.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sheridan.popovann.assignment2.data.local.flowerList
import sheridan.popovann.assignment2.domain.Flower
import javax.inject.Inject

class FakeFlowerDataRepository @Inject constructor(): FlowerDataRepository {

    override suspend fun getAllFlowers(): List<Flower> =
        withContext(Dispatchers.IO) {
            flowerList
        }
}