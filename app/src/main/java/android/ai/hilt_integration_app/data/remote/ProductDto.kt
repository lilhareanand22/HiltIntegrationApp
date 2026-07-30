package android.ai.hilt_integration_app.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import android.ai.hilt_integration_app.domain.Product

/**
 * Data Transfer Object for Product from API.
 */
@JsonClass(generateAdapter = true)
data class ProductDto(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "price") val price: Double,
    @Json(name = "description") val description: String,
    @Json(name = "category") val category: String,
    @Json(name = "image") val image: String
) {
    fun toDomain(): Product = Product(id, title, price, description, category, image)
}