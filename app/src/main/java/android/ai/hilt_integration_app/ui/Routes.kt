package android.ai.hilt_integration_app.ui

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable data object Auth : Route
    @Serializable data object Catalog : Route
    @Serializable data object Interview : Route
    @Serializable data object Products : Route
}