package com.leokenzley.kotlinapi.core.ports.`in`.users

import com.leokenzley.kotlinapi.core.domain.UserDomain

interface UpdateUserUseCase {
    fun execute(id: Long, user: UserDomain): UserDomain
}