package com.leokenzley.kotlinapi.application.service

import com.leokenzley.kotlinapi.dto.UserRequest
import com.leokenzley.kotlinapi.dto.UserResponse
import com.leokenzley.kotlinapi.application.mapper.UserMapper
import com.leokenzley.kotlinapi.core.ports.`in`.users.*
import com.leokenzley.kotlinapi.core.usecase.handler.exception.UserNotFoundException
import com.leokenzley.kotlinapi.dto.PaginatedUserResponse
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class UserService(
    private val createUserUseCase: CreateUserUseCase,
    private val listUsersUseCase: ListUsersUseCase,
    private val findUserByIdUseCase: FindUserByIdUseCase,
    private val deleteUserUseCase: DeleteUserUseCase,
    private val paginationUseCase: PaginationUseCase
) {
    fun createUser(request: UserRequest): UserResponse {
        val user = UserMapper.toDomain(request)
        val created = createUserUseCase.execute(user)
        return UserMapper.toResponse(created)
    }

    fun listUsers(): List<UserResponse> = listUsersUseCase.find().map { UserMapper.toResponse(it) }

    fun findById(id: Long): UserResponse {
        val user = findUserByIdUseCase.find(id)
            ?: throw UserNotFoundException("Resource not found")
        return UserMapper.toResponse(user)
    }

    fun deleteUser(id: Long) {
        val user = findUserByIdUseCase.find(id)
            ?: throw UserNotFoundException("Resource not found")
        user.id?.let { deleteUserUseCase.execute(it) }
    }

    fun updateUser(id: Long, request: UserRequest): UserResponse {
        val user = findUserByIdUseCase.find(id)
            ?: throw UserNotFoundException("Resource not found")
        val updatedUser = user.copy(
            name = request.name,
            email = request.email,
         )
        return UserMapper.toResponse(updatedUser)
    }

    fun findPaginated(pageable: Pageable): PaginatedUserResponse?
    = paginationUseCase.find(pageable);
}
