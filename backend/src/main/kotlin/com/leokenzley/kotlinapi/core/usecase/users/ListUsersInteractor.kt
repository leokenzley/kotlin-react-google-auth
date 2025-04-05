package com.leokenzley.kotlinapi.core.usecase.users

import com.leokenzley.kotlinapi.core.domain.UserDomain
import com.leokenzley.kotlinapi.core.ports.`in`.users.ListUsersUseCase
import com.leokenzley.kotlinapi.core.ports.out.UserRepository
import org.springframework.stereotype.Component

@Component
class ListUsersInteractor (private val userRepository: UserRepository) : ListUsersUseCase {
    override fun find(): List<UserDomain> {
        val users = userRepository.findAll()
        return users
    }
}