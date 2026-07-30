package android.ai.hilt_integration_app.data.repository

import android.ai.hilt_integration_app.data.local.AuthDataStore
import android.ai.hilt_integration_app.domain.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val authDataStore: AuthDataStore
) : AuthRepository {
    override val isLoggedIn: Flow<Boolean> = authDataStore.isLoggedIn

    override suspend fun login() {
        authDataStore.setLoggedIn(true)
    }

    override suspend fun logout() {
        authDataStore.setLoggedIn(false)
    }
}