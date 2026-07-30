package android.ai.hilt_integration_app.ui.interview

import kotlinx.serialization.Serializable

@Serializable
data class InterviewQuestion(
    val id: String,
    val question: String,
    val answer: String,
    val level: String // Easy, Medium, Hard, Staff
)

val interviewQuestions = listOf(
    InterviewQuestion(
        "q1",
        "What is the difference between @Provides and @Binds?",
        "@Provides is used for classes that you don't own (like Retrofit) or when you need to perform initialization logic. @Binds is used for interface binding and is more efficient because Hilt doesn't need to generate a factory class.",
        "Medium"
    ),
    InterviewQuestion(
        "q2",
        "How do you handle circular dependencies in Hilt?",
        "Hilt/Dagger doesn't support circular dependencies by default. You should refactor your architecture. If absolutely necessary, use a Provider<T> or Lazy<T> to break the cycle.",
        "Hard"
    ),
    InterviewQuestion(
        "q3",
        "Explain Hilt Entry Points.",
        "@EntryPoint is used to access dependencies in classes not supported by Hilt (e.g., dynamic feature modules, non-Hilt classes, or content providers). You retrieve it using EntryPoints.get().",
        "Staff"
    ),
    InterviewQuestion(
        "q4",
        "What is @AssistedInject and when to use it?",
        "@AssistedInject is used when a dependency requires runtime parameters alongside Hilt-managed dependencies. You define an @AssistedFactory to create the object with runtime values.",
        "Staff"
    )
)