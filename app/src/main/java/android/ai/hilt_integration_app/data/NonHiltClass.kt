package android.ai.hilt_integration_app.data

import android.content.Context
import android.ai.hilt_integration_app.domain.ProductRepository
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Demonstrates @EntryPoint usage.
 * Used to retrieve dependencies in classes that Hilt doesn't support directly
 * or when you need to manually fetch a dependency from a component.
 */
class NonHiltClass(context: Context) {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface RepositoryEntryPoint {
        fun productRepository(): ProductRepository
    }

    private val repository: ProductRepository = EntryPoints.get(
        context.applicationContext,
        RepositoryEntryPoint::class.java
    ).productRepository()

    fun doSomething() {
        // Use repository manually
        println("Accessing repository from Non-Hilt class: $repository")
    }
}