package com.leokenzley.kotlinapi.core.ports.`in`.users

import com.leokenzley.kotlinapi.core.domain.UserDomain

interface ListUsersUseCase {
    fun find(): List<UserDomain>
}