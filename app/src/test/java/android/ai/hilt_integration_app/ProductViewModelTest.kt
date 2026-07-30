package android.ai.hilt_integration_app

import android.ai.hilt_integration_app.domain.Product
import android.ai.hilt_integration_app.domain.ProductRepository
import android.ai.hilt_integration_app.ui.product.ProductViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ProductViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var viewModel: ProductViewModel
    private lateinit var fakeRepository: FakeProductRepository

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        fakeRepository = FakeProductRepository()
        viewModel = ProductViewModel(fakeRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `products state flow emits correct data from repository`() = runTest {
        val testProducts = listOf(
            Product(1, "Test 1", 10.0, "D1", "C1", "I1"),
            Product(2, "Test 2", 20.0, "D2", "C2", "I2")
        )
        
        val fakeRepo = FakeProductRepository()
        fakeRepo.emit(testProducts)
        val viewModel = ProductViewModel(fakeRepo)
        
        // Wait for the first non-empty emission
        val result = viewModel.products.first { it.isNotEmpty() }

        assertEquals(testProducts, result)
    }

    class FakeProductRepository : ProductRepository {
        private val _products = MutableStateFlow<List<Product>>(emptyList())

        fun emit(value: List<Product>) {
            _products.value = value
        }

        override fun getProducts(): Flow<List<Product>> = _products

        override suspend fun refreshProducts(): Result<Unit> {
            return Result.success(Unit)
        }
    }
}