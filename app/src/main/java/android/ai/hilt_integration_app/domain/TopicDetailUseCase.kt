package android.ai.hilt_integration_app.domain

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

/**
 * UseCase demonstrating Assisted Injection.
 * Used when you need to pass a runtime parameter (topicId) alongside injected dependencies.
 */
class TopicDetailUseCase @AssistedInject constructor(
    private val repository: ProductRepository, // Injected by Hilt
    @Assisted private val topicId: String // Passed at runtime
) {
    fun getTopicDetail(): String {
        return "Detail for topic $topicId using repository: $repository"
    }

    @AssistedFactory
    interface Factory {
        fun create(topicId: String): TopicDetailUseCase
    }
}