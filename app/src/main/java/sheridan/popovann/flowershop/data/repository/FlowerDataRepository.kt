package sheridan.popovann.flowershop.data.repository

import sheridan.popovann.flowershop.domain.Flower

interface FlowerDataRepository {
    suspend fun getAllFlowers(): List<Flower>
}