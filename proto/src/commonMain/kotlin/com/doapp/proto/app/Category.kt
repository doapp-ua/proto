package com.doapp.proto.app

import com.doapp.proto.endpoint
import io.ktor.http.*
import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: Long,
    val url: String,
    val imageUrl: String? = null
)

@Resource("/categories")
class CategoriesRes {
    @Resource("{appId}")
    class ListAll(val parent: CategoriesRes = CategoriesRes(), val appId: Long)

    companion object {
        val ListAll = endpoint<ListAll, Long, List<Category>>(HttpMethod.Get)
    }
}