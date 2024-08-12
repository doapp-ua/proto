package com.doapp.proto

import io.ktor.http.*
import io.ktor.util.reflect.*

class Endpoint<Res, Req, Resp>(val httpMethod : HttpMethod, inputTypeInfo: TypeInfo) {
    val hasInput = inputTypeInfo.type != Unit::class
}

inline fun <Res, reified Req, reified Resp> endpoint(
    httpMethod : HttpMethod
) : Endpoint<Res, Req, Resp> {
    val inputTypeInfo : TypeInfo = typeInfo<Req>()
    return Endpoint(httpMethod, inputTypeInfo)
}