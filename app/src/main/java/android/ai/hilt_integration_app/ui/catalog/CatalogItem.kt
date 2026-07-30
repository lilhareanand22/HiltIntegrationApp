package android.ai.hilt_integration_app.ui.catalog

import kotlinx.serialization.Serializable

@Serializable
data class CatalogItem(
    val id: String,
    val title: String,
    val description: String,
    val codeSnippet: String
)

val catalogItems = listOf(
    CatalogItem(
        "hilt-fundamentals",
        "Hilt Fundamentals",
        "Learn about @HiltAndroidApp, @Inject, and @Module.",
        "// Example\n@HiltAndroidApp\nclass MyApp : Application()"
    ),
    CatalogItem(
        "components-scopes",
        "Components & Scopes",
        "Understanding @Singleton, @ActivityScoped and life cycles.",
        "@Singleton\n@Component\ninterface SingletonComponent"
    ),
    CatalogItem(
        "assisted-injection",
        "Assisted Injection",
        "How to inject dependencies with runtime parameters.",
        "@AssistedInject\nconstructor(\n  @Assisted val id: String,\n  repository: Repository\n)"
    ),
    CatalogItem(
        "entry-points",
        "Entry Points",
        "Access dependencies in non-Hilt classes.",
        "@EntryPoint\n@InstallIn(SingletonComponent::class)\ninterface MyEntryPoint {\n  fun repo(): Repository\n}"
    ),
    CatalogItem(
        "work-manager",
        "WorkManager Integration",
        "Using @HiltWorker for background tasks.",
        "@HiltWorker\nclass MyWorker @AssistedInject constructor(...)"
    ),
    CatalogItem(
        "android-components",
        "Android Components",
        "DI in Services and BroadcastReceivers.",
        "@AndroidEntryPoint\nclass MyService : Service() {\n  @Inject lateinit var repo: Repo\n}"
    )
)