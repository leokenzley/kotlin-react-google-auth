package com.leokenzley.kotlinapi.application.controller

import com.leokenzley.kotlinapi.api.UsersApi
import com.leokenzley.kotlinapi.application.service.UserService
import com.leokenzley.kotlinapi.dto.PaginatedUserResponse
import com.leokenzley.kotlinapi.dto.UserRequest
import com.leokenzley.kotlinapi.dto.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) : UsersApi {
    override fun deleteUser(id: Int): ResponseEntity<Unit> {
        TODO("Not yet implemented")
    }

    override fun getUserById(id: Int): ResponseEntity<UserResponse> {
        TODO("Not yet implemented")
    }

    override fun updateUser(id: Int, userRequest: UserRequest): ResponseEntity<UserResponse> {
        TODO("Not yet implemented")
    }

    override fun usersGet(): ResponseEntity<List<UserResponse>> {
        TODO("Not yet implemented")
    }

    override fun usersPaginatedGet(page: Int, size: Int, sort: String): ResponseEntity<PaginatedUserResponse> {
        TODO("Not yet implemented")
    }

    override fun usersPost(userRequest: UserRequest): ResponseEntity<UserResponse>  = ResponseEntity.ok(userService.createUser(userRequest))

}