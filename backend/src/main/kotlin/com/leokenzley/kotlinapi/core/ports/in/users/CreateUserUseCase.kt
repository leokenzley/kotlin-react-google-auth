package com.leokenzley.kotlinapi.core.ports.`in`.users

import com.leokenzley.kotlinapi.core.domain.UserDomain

interface CreateUserUseCase {
    fun execute(user: UserDomain): UserDomain
}