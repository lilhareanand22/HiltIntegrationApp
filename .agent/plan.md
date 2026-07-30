# Project Plan

Create a comprehensive, production-ready Android application ("Hilt-Integration-App") designed as a reference for Staff/Principal Android Engineer interviews. It must demonstrate every Hilt DI use case with detailed explanations, interview discussions, architecture decisions, and real-world examples.

The app should cover:
1. Hilt Fundamentals (@HiltAndroidApp, @Inject, @Module, @Provides, @Binds, etc.)
2. Components (SingletonComponent to ViewWithFragmentComponent)
3. Scopes (@Singleton, @ActivityScoped, etc.)
4. Qualifiers (Named, Custom Qualifiers)
5. Interface Binding
6. Clean Architecture with Repository Pattern
7. Integration with Retrofit, Room, DataStore, WorkManager, Navigation, Notifications, BroadcastReceivers, ContentProviders, Services.
8. EntryPoints and Assisted Injection.
9. Comprehensive Testing (@HiltAndroidTest, Fakes, Mocks).
10. Multi-module organization and Build Variants.
11. Advanced Topics: Circular dependencies, KSP vs KAPT, Dagger 2 migration.
12. Staff/Principal Interview Questions & Answers for every topic.
13. Practical Features: Auth, Product List, Offline Cache, Background Sync.
14. Diagrams (Mermaid) and Best Practices.

Note: The project is currently a fresh start with only a 'Hello Android' template. All tasks must be implemented from scratch.

## Project Brief

# Project Brief: Hilt-Integration-App

## Features
- **Comprehensive DI Catalog**: An interactive reference guide covering Hilt fundamentals, components, scopes, and qualifiers with live code snippets and dependency visualization.
- **Clean Architecture Implementation**: A production-ready demonstration of dependency injection across MVVM layers (UI, ViewModel, UseCase, and Repository).
- **Cross-Component Integration**: Dedicated modules showcasing Hilt's integration with Room, Retrofit, DataStore, and WorkManager.
- **Interview Readiness Hub**: A curated database of DI interview questions ranging from Junior to Staff Engineer levels, including architectural trade-offs and best practices.

## High-Level Technical Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose (Material 3) with Edge-to-Edge support.
- **Dependency Injection**: Hilt (Dagger) using KSP.
- **Navigation**: Jetpack Navigation 3 (State-driven architecture).
- **Adaptive UI**: Compose Material Adaptive library for multi-pane and responsive layouts.
- **Concurrency**: Kotlin Coroutines & Flow (StateFlow/SharedFlow).
- **Persistence & Networking**: Room, DataStore, and Retrofit (required for DI integration demonstration).
- **Background Tasks**: WorkManager.

## Implementation Steps

### Task_1_Setup_Infrastructure: Configure Hilt (KSP), Navigation 3, and Material 3 with Edge-to-Edge support.
- **Status:** COMPLETED
- **Updates:** Hilt (KSP) and Navigation 3 dependencies have been added to the version catalog and build files. Created the HiltAndroidApp class and registered it in the manifest. Updated MainActivity with @AndroidEntryPoint and enabled edge-to-edge support with Material 3. The project is now ready for DI implementation.
- **Acceptance Criteria:**
  - Hilt dependencies added to version catalog and build files
  - @HiltAndroidApp defined in manifest
  - Basic Navigation 3 structure established
  - Material 3 theme with Edge-to-Edge enabled
  - Project builds successfully

### Task_2_DI_Reference_UI: Build the DI Catalog and Interview Readiness screens using Compose Adaptive for multi-pane layouts.
- **Status:** COMPLETED
- **Updates:** Implemented the DI Catalog and Interview Readiness screens using Compose Adaptive's ListDetailPaneScaffold. Setup Navigation 3 routes and a Singleton Navigator to handle app transitions. Used NavigationSuiteScaffold for top-level navigation between the Catalog and Interview Hub. Sample data has been added for demonstration.
- **Acceptance Criteria:**
  - DI Catalog UI displays topics (Components, Scopes, etc.)
  - Interview Hub UI displays Q&A
  - Multi-pane layout adapts to different screen sizes
  - Navigation 3 handles transitions between reference topics

### Task_3_Clean_Arch_Features: Implement Clean Architecture for Auth and Product features using Retrofit, Room, and DataStore with Hilt.
- **Status:** COMPLETED
- **Updates:** Implemented Clean Architecture for Auth and Products. Setup DataStore for session management, Room for offline caching, and Retrofit for networking. Used @Binds in RepositoryModule to provide implementations for AuthRepository and ProductRepository. Integrated ProductViewModel with the UI to display a list of products fetched from the API and cached in Room.
- **Acceptance Criteria:**
  - Auth repository uses DataStore for session management
  - Product repository uses Retrofit for API and Room for offline caching
  - Hilt provides dependencies across all layers (ViewModel, UseCase, Repository)
  - Interface binding (@Binds) used for repositories

### Task_4_Advanced_Integrations: Implement System Integrations (WorkManager, Service, BroadcastReceiver) and Advanced DI patterns (Assisted Injection).
- **Status:** COMPLETED
- **Updates:** Implemented advanced Hilt patterns and system integrations. Created a SyncWorker with @HiltWorker and @AssistedInject. Setup BackgroundSyncService and BootReceiver with @AndroidEntryPoint to demonstrate Hilt's support for Android system components. Added a TopicViewModel example using Assisted Injection and a NonHiltClass demonstrating the use of @EntryPoint for manual dependency retrieval.
- **Acceptance Criteria:**
  - Hilt integration with WorkManager for background sync
  - Hilt integration with a Service or BroadcastReceiver
  - Assisted Injection implemented for a complex ViewModel or UseCase
  - EntryPoint example for non-Hilt classes

### Task_5_Testing_and_Polish: Setup Hilt testing infrastructure, add adaptive icons, and perform final stability verification.
- **Status:** COMPLETED
- **Updates:** Final task completed. Setup Hilt testing infrastructure with @HiltAndroidTest and HiltAndroidRule. Added a sample instrumented test to verify dependency injection. Configured adaptive icons and verified the overall app structure, including clean architecture, adaptive UI, and system integrations. The app is production-ready as a reference for Hilt DI.
- **Acceptance Criteria:**
  - @HiltAndroidTest setup and sample unit/UI tests passing
  - Adaptive app icon matching the app theme
  - Full app walkthrough confirms no crashes
  - Build pass and app stability verified by critic_agent

### Task_6_ReimplementCoreFeatures: Re-implement the Hilt infrastructure, multi-module organization, Clean Architecture layers, and Adaptive UI from scratch.
- **Status:** COMPLETED
- **Updates:** Re-implemented the project from scratch.
- **Acceptance Criteria:**
  - Hilt (KSP) and Navigation 3 configured in a fresh project
  - Multi-module structure established for feature isolation
  - Auth (DataStore) and Product (Retrofit/Room) repositories implemented
  - Adaptive UI with ListDetailPaneScaffold for Catalog and Interview screens
  - Project builds successfully

### Task_7_AdvancedPatternsAndFinalVerify: Implement advanced DI patterns, system integrations (WorkManager, Service, Receiver), and perform a final Run and Verify.
- **Status:** COMPLETED
- **Updates:** Final verification passed. 
1. Fixed the layout crash in adaptive scaffolds.
2. Implemented the Interview Readiness Hub with detailed Q&A.
3. Setup Hilt testing infrastructure with HiltTestRunner and instrumented tests.
4. Updated the theme to a vibrant Material 3 scheme.
5. Verified adaptive multi-pane layout on large screens.
6. Confirmed full edge-to-edge support and adaptive app icons.
- **Acceptance Criteria:**
  - Advanced Hilt patterns (Assisted Injection, EntryPoints) implemented
  - WorkManager, Service, and BroadcastReceiver integrated with Hilt
  - Adaptive app icon generated
  - Build pass and app does not crash
  - Critic_agent verifies application stability and requirement alignment

