package com.leokenzley.kotlinapi.core.ports.`in`.users

import com.leokenzley.kotlinapi.core.domain.UserDomain

interface FindUserByIdUseCase {
    fun find(id: Long): UserDomain?
}