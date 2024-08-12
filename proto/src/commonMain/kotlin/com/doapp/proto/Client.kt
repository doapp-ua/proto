package com.doapp.proto

import io.ktor.http.*
import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
data class ClientData(
    val phone: String,
    val name: String
)

@Serializable
data class SendPasswordRequest(
    val appId: Long,
    val phone: String
)

@Serializable
data class ClientAuthRequest(
    val phone: String,
    val code: String
)

@Serializable
data class ClientAuthResponse(
    val accessToken: String,
    val dataRequired: Boolean
)

@Serializable
data class ClientDataRequest(
    val name: String
)

@Serializable
data class FcmTokenRequest(
    val token: String
)

@Serializable
data class SessionInfo(
    val valid: Boolean
)

@Resource("/client")
class ClientRes {
    @Resource("/sendPassword")
    class SendPassword(val parent: ClientRes = ClientRes())
    @Resource("/signIn")
    class SignIn(val parent: ClientRes = ClientRes())
    @Resource("/checkSession")
    class CheckSession(val parent: ClientRes = ClientRes())
    @Resource("/signOut")
    class SignOut(val parent: ClientRes = ClientRes())
    @Resource("/updateData")
    class UpdateData(val parent: ClientRes = ClientRes())
    @Resource("/updateFcmToken")
    class UpdateFcmToken(val parent: ClientRes = ClientRes())

    companion object {
        val SendPassword = endpoint<SendPassword, SendPasswordRequest, Unit>(HttpMethod.Post)
        val SignIn = endpoint<SignIn, ClientAuthRequest, ClientAuthResponse>(HttpMethod.Post)
        val CheckSession = endpoint<CheckSession, Unit, SessionInfo>(HttpMethod.Get)
        val SignOut = endpoint<SignOut, Unit, Unit>(HttpMethod.Get)
        val UpdateData = endpoint<UpdateData, ClientDataRequest, Unit>(HttpMethod.Post)
        val UpdateFcmToken = endpoint<UpdateFcmToken, FcmTokenRequest, Unit>(HttpMethod.Post)
    }
}