# Testing Walkthrough

I have implemented a comprehensive testing suite that demonstrates how to test an Android app with Hilt, covering both local JVM unit tests and on-device instrumented tests.

## Changes Made

### 1. Fakes for Decoupled Testing
Created [FakeFakeStoreApi.kt](file:///C:/Users/Varsha/Documents/WorkSpcace/Jetpack_Compose_Trainng_Sources_Code/HiltIntegrationApp/app/src/androidTest/java/android/ai/hilt_integration_app/fakes/FakeFakeStoreApi.kt) which implements the `FakeStoreApi` interface. This allows us to test the repository without needing an actual internet connection.

### 2. Hilt Instrumented Test
Implemented [ProductRepositoryHiltTest.kt](file:///C:/Users/Varsha/Documents/WorkSpcace/Jetpack_Compose_Trainng_Sources_Code/HiltIntegrationApp/app/src/androidTest/java/android/ai/hilt_integration_app/ProductRepositoryHiltTest.kt).
- **Dependency Replacement**: Used `@TestInstallIn` to replace the production `NetworkModule` with a `TestNetworkModule`. This tells Hilt to inject our `FakeFakeStoreApi` whenever a `FakeStoreApi` is requested during tests.
- **Verification**: The test verifies that calling `repository.refreshProducts()` correctly updates the local database and that `getProducts()` retrieves the data as expected.

### 3. Local Unit Test
Implemented [ProductViewModelTest.kt](file:///C:/Users/Varsha/Documents/WorkSpcace/Jetpack_Compose_Trainng_Sources_Code/HiltIntegrationApp/app/src/test/java/android/ai/hilt_integration_app/ProductViewModelTest.kt).
- **Fast Execution**: These tests run on the JVM (no emulator needed) and use `kotlinx-coroutines-test` to manage background tasks.
- **StateFlow Testing**: Demonstrates how to test `StateFlow` by awaiting the first non-empty emission from the repository.

## Verification Results

### Automated Tests
- **Unit Tests**: Passed (2 tests total).
- **Instrumented Tests**: Passed (3 tests total, including original DI tests).

```
:app:testDebugUnitTest -> 2 passed, 0 failed
:app:connectedDebugAndroidTest -> 3 passed, 0 failed
```

> [!TIP]
> Always use `@TestInstallIn` when you want to replace a production dependency globally for all tests in a test suite. For single-test replacements, you can use `@UninstallModules`.
