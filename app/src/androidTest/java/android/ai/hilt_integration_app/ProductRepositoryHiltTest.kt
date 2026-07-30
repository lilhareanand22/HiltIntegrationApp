package android.ai.hilt_integration_app

import android.ai.hilt_integration_app.data.remote.FakeStoreApi
import android.ai.hilt_integration_app.di.NetworkModule
import android.ai.hilt_integration_app.domain.ProductRepository
import android.ai.hilt_integration_app.fakes.FakeFakeStoreApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Singleton

@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [NetworkModule::class]
)
@Module
object TestNetworkModule {
    @Provides
    @Singleton
    fun provideFakeStoreApi(): FakeStoreApi = FakeFakeStoreApi()
}

@HiltAndroidTest
class ProductRepositoryHiltTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repository: ProductRepository

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun testRefreshAndGetProducts() = runBlocking {
        // Trigger refresh which uses our FakeFakeStoreApi
        repository.refreshProducts()

        // Observe the database (which should now contain our fake products)
        val products = repository.getProducts().first()

        assertEquals(2, products.size)
        assertEquals("Fake Product 1", products[0].title)
        assertEquals("Fake Product 2", products[1].title)
    }
}