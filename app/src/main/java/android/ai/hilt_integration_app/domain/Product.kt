package android.ai.hilt_integration_app.domain

/**
 * Domain model representing a Product.
 * This is the pure business logic representation, decoupled from database or network models.
 */
data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String
)