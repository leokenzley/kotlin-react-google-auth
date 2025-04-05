package com.leokenzley.kotlinapi.application.controller

import com.leokenzley.kotlinapi.api.UsersApi
import com.leokenzley.kotlinapi.application.service.UserService
import com.leokenzley.kotlinapi.dto.PaginatedUserResponse
import com.leokenzley.kotlinapi.dto.UserRequest
import com.leokenzley.kotlinapi.dto.UserResponse
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) : UsersApi {
    override fun deleteUser(id: Long): ResponseEntity<Unit> {
        userService.deleteUser(id)
        return ResponseEntity.noContent().build()
    }

    override fun getUserById(id: Long): ResponseEntity<UserResponse> = ResponseEntity.ok(userService.findById(id))

    override fun updateUser(id: Long, userRequest: UserRequest): ResponseEntity<UserResponse> = ResponseEntity.ok(userService.updateUser(id, userRequest))

    override fun usersGet(): ResponseEntity<List<UserResponse>> = ResponseEntity.ok(userService.listUsers())

    override fun usersPaginatedGet(page: Int, size: Int, sort: String): ResponseEntity<PaginatedUserResponse> {
        var direction: Sort.Direction = Sort.Direction.DESC
        var property: String = "id"
        if (!sort.isNullOrBlank()){
            direction = if (sort.split(",").get(1).uppercase() == "ASC") Sort.Direction.ASC else Sort.Direction.DESC
            property = sort.split(",").get(0)
        }
        val pageable = PageRequest.of(page, size, direction, property)
        val paginatedUsers = userService.findPaginated(pageable)
        return ResponseEntity.ok(paginatedUsers)
    }

    override fun usersPost(userRequest: UserRequest): ResponseEntity<UserResponse>  = ResponseEntity.ok(userService.createUser(userRequest))

}