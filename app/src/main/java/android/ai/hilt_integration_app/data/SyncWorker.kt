package android.ai.hilt_integration_app.data

import android.content.Context
import android.ai.hilt_integration_app.domain.ProductRepository
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

/**
 * Worker demonstrating Hilt integration with WorkManager.
 * @HiltWorker and @AssistedInject are required for WorkManager DI.
 */
@HiltWorker
class SyncWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val repository: ProductRepository
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            repository.refreshProducts()
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}