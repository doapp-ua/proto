package com.doapp.proto

import kotlinx.serialization.Serializable

@Serializable
data class IdsRequest(val ids: List<Long>)

@Serializable
data class PagingRequest(
    val containerId: Long,
    val offset: Long,
    val limit: Int
)