package android.ai.hilt_integration_app.domain

import kotlinx.coroutines.flow.Flow

/**
 * Interface defining Product related operations.
 * This lives in the domain layer to follow Dependency Inversion Principle.
 */
interface ProductRepository {
    fun getProducts(): Flow<List<Product>>
    suspend fun refreshProducts(): Result<Unit>
}