package com.leokenzley.kotlinapi.core.usecase.users

import com.leokenzley.kotlinapi.core.domain.UserDomain
import com.leokenzley.kotlinapi.core.ports.`in`.users.FindUserByIdUseCase
import com.leokenzley.kotlinapi.core.ports.out.UserRepository
import org.springframework.stereotype.Component

@Component
class FindUserByIdInteractor( private val userRepository: UserRepository) : FindUserByIdUseCase {
    override fun find(id: Long): UserDomain? = userRepository.findById(id)
        ?: throw IllegalArgumentException("User with id $id not found")

}