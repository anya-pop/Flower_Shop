package sheridan.popovann.assignment2.data.repository

import sheridan.popovann.assignment2.domain.Flower

interface FlowerDataRepository {
    suspend fun getAllFlowers(): List<Flower>
}