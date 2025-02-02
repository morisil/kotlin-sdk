package io.modelcontextprotocol.kotlin.sdk.shared

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.ClassDiscriminatorMode
import kotlinx.serialization.json.Json

@RequiresOptIn(message = "This API is for module-b only")
public annotation class InternalMcpApi

@OptIn(ExperimentalSerializationApi::class)
@InternalMcpApi
public val McpJson: Json by lazy {
    Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
        isLenient = true
        classDiscriminatorMode = ClassDiscriminatorMode.NONE
        explicitNulls = false
    }
}
