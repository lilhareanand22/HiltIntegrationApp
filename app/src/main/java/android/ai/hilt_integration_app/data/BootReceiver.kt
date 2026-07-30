package android.ai.hilt_integration_app.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.ai.hilt_integration_app.domain.ProductRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * BroadcastReceiver demonstrating Hilt integration.
 * @AndroidEntryPoint enables member injection in standard Android components.
 */
@AndroidEntryPoint
class BootReceiver : BroadcastReceiver() {

    @Inject
    lateinit var repository: ProductRepository

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            println("Boot completed. Repository injected: $repository")
        }
    }
}