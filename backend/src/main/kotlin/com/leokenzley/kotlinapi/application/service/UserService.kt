package com.leokenzley.kotlinapi.application.service

import com.leokenzley.kotlinapi.dto.UserRequest
import com.leokenzley.kotlinapi.dto.UserResponse
import com.leokenzley.kotlinapi.application.mapper.UserMapper
import com.leokenzley.kotlinapi.core.ports.`in`.users.CreateUserUseCase
import org.springframework.stereotype.Service

@Service
class UserService(
    private val createUserUseCase: CreateUserUseCase
) {
    fun createUser(request: UserRequest): UserResponse {
        val user = UserMapper.toDomain(request)
        val created = createUserUseCase.execute(user)
        return UserMapper.toResponse(created)
    }
}
