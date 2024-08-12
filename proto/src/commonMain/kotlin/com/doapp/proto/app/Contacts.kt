package com.doapp.proto.app

import com.doapp.proto.endpoint
import io.ktor.http.*
import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
data class Contacts(
    val links: SocialLinks,
    val subsidiaries: List<Subsidiary>
)

@Serializable
data class SocialLinks(
    val generalPhone: String,
    val website: String? = null,
    val instagram: String? = null,
    val facebook: String? = null,
    val twitter: String? = null,
    val youtube: String? = null,
)

@Serializable
data class Subsidiary(
    val id: Long,
    val phone: String,
    val address: String,
    val workingHours: String,
    val mapsUrl: String? = null
)

@Resource("/contacts")
class ContactsRes {
    @Resource("{appId}")
    class Get(val parent: ContactsRes = ContactsRes(), val appId: Long)

    companion object {
        val Get = endpoint<Get, Long, Contacts>(HttpMethod.Get)
    }
}