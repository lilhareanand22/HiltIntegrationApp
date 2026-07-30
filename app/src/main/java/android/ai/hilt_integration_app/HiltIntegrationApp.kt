package android.ai.hilt_integration_app

import android.app.Application
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import androidx.hilt.work.HiltWorkerFactory

/**
 * The Application class for Hilt-Integration-App.
 *
 * @HiltAndroidApp triggers Hilt's code generation, including a base class for your application
 * that serves as the application-level dependency container.
 *
 * This container is the parent component of the app, which means that other components
 * can access the dependencies that it provides.
 */
@HiltAndroidApp
class HiltIntegrationApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
}