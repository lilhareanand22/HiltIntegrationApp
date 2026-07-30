package android.ai.hilt_integration_app.domain

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val isLoggedIn: Flow<Boolean>
    suspend fun login()
    suspend fun logout()
}