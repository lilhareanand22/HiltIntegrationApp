package android.ai.hilt_integration_app.fakes

import android.ai.hilt_integration_app.data.remote.FakeStoreApi
import android.ai.hilt_integration_app.data.remote.ProductDto

class FakeFakeStoreApi : FakeStoreApi {
    private var products = listOf(
        ProductDto(1, "Fake Product 1", 10.0, "Desc 1", "Cat 1", "image1"),
        ProductDto(2, "Fake Product 2", 20.0, "Desc 2", "Cat 2", "image2")
    )

    override suspend fun getProducts(): List<ProductDto> {
        return products
    }
}