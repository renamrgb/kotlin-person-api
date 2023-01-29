package com.github.renamrgb.restwithkotlin.data.vo.v1

import java.util.*

data class TokenVO(
    val username: String? = null,
    val authenticated: Boolean? = null,
    val created: Date? = null,
    val expiration: Date? = null,
    val accesToken: String? = null,
    val refreshToken: String? = null
)
