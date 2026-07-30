package android.ai.hilt_integration_app.di

import android.ai.hilt_integration_app.data.repository.AuthRepositoryImpl
import android.ai.hilt_integration_app.data.repository.ProductRepositoryImpl
import android.ai.hilt_integration_app.domain.AuthRepository
import android.ai.hilt_integration_app.domain.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt module for binding interfaces to implementations.
 * Using @Binds is more efficient than @Provides for interface binding.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindProductRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository
}