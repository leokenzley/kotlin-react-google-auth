package com.leokenzley.kotlinapi.core.usecase.users

import com.leokenzley.kotlinapi.core.domain.UserDomain
import com.leokenzley.kotlinapi.core.ports.`in`.users.DeleteUserUseCase
import com.leokenzley.kotlinapi.core.ports.out.UserRepository
import com.leokenzley.kotlinapi.core.usecase.handler.exception.UserNotFoundException
import org.springframework.stereotype.Component

@Component
class DeleteUserInteractor(private val userRepository: UserRepository) : DeleteUserUseCase {

    override fun execute(id: Long) {
        val user: UserDomain = userRepository.findById(id)
            ?: throw UserNotFoundException("Resource not found")
        userRepository.deleteById(id)
    }
}