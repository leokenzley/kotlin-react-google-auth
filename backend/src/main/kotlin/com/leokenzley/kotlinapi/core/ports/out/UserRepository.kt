package com.leokenzley.kotlinapi.core.ports.out

import com.leokenzley.kotlinapi.core.domain.UserDomain

interface UserRepository {
    fun save(user: UserDomain): UserDomain
}