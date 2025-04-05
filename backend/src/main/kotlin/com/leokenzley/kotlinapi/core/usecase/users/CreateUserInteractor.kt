package com.leokenzley.kotlinapi.core.usecase.users

import com.leokenzley.kotlinapi.core.domain.UserDomain
import com.leokenzley.kotlinapi.core.ports.`in`.users.CreateUserUseCase
import com.leokenzley.kotlinapi.core.ports.out.UserRepository

/**
 * Interactor for creating a user.
 *
 * @property repository The user repository to save the user.
 */
class CreateUserInteractor (private val repository: UserRepository): CreateUserUseCase {
    override fun execute(user: UserDomain) = repository.save(user)
}