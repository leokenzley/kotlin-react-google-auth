package com.leokenzley.kotlinapi.core.usecase.users

import com.leokenzley.kotlinapi.core.domain.UserDomain
import com.leokenzley.kotlinapi.core.ports.`in`.users.UpdateUserUseCase
import com.leokenzley.kotlinapi.core.ports.out.UserRepository
import org.springframework.stereotype.Component

@Component
class UpdateUserInteractor(private val userRepository: UserRepository) : UpdateUserUseCase {
    override fun execute(id: Long, user: UserDomain): UserDomain {
        val user: UserDomain = userRepository.findById(id)
            ?: throw IllegalArgumentException("User with id $id not found")
        user.copy(id = id)
        return userRepository.save(user)
    }
}