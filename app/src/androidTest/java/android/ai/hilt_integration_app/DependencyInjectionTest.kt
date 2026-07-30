package android.ai.hilt_integration_app

import android.ai.hilt_integration_app.domain.ProductRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

/**
 * Instrumented test verifying Hilt dependency injection.
 */
@HiltAndroidTest
class DependencyInjectionTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repository: ProductRepository

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun testRepositoryInjection() {
        assertNotNull("Repository should be injected by Hilt", repository)
    }
}