package android.ai.hilt_integration_app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.ai.hilt_integration_app.domain.Product

/**
 * Room Entity for Product persistence.
 */
@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String
) {
    fun toDomain(): Product = Product(id, title, price, description, category, image)
}

fun Product.toEntity(): ProductEntity = ProductEntity(id, title, price, description, category, image)