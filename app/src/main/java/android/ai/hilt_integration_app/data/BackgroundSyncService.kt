package android.ai.hilt_integration_app.data

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.ai.hilt_integration_app.domain.ProductRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Service demonstrating Hilt integration.
 * @AndroidEntryPoint handles dependency injection for Services.
 */
@AndroidEntryPoint
class BackgroundSyncService : Service() {

    @Inject
    lateinit var repository: ProductRepository

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("Service started. Repository injected: $repository")
        return START_NOT_STICKY
    }
}