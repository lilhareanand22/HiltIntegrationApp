package android.ai.hilt_integration_app.data.repository

import android.ai.hilt_integration_app.data.local.ProductDao
import android.ai.hilt_integration_app.data.local.toEntity
import android.ai.hilt_integration_app.data.remote.FakeStoreApi
import android.ai.hilt_integration_app.domain.Product
import android.ai.hilt_integration_app.domain.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Implementation of ProductRepository.
 * Uses constructor injection with @Inject.
 */
@Singleton
class ProductRepositoryImpl @Inject constructor(
    private val api: FakeStoreApi,
    private val dao: ProductDao
) : ProductRepository {

    override fun getProducts(): Flow<List<Product>> {
        return dao.getAllProducts().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun refreshProducts(): Result<Unit> {
        return try {
            val remoteProducts = api.getProducts()
            dao.deleteAllProducts()
            dao.insertProducts(remoteProducts.map { it.toDomain().toEntity() })
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}