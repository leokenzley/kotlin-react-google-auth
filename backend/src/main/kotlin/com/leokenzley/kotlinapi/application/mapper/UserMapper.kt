package com.leokenzley.kotlinapi.application.mapper

import com.leokenzley.kotlinapi.dto.UserRequest
import com.leokenzley.kotlinapi.dto.UserResponse
import com.leokenzley.kotlinapi.core.domain.UserDomain

object UserMapper {
    fun toDomain(req: UserRequest) = UserDomain(
        name = req.name,
        email = req.email,
        status = UserDomain.Status.ACTIVE
    )

    fun toResponse(user: UserDomain) = UserResponse(
        id = user.id!!,
        name = user.name,
        email = user.email,
        status = user.status.code
    )
}