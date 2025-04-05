package com.leokenzley.kotlinapi.configuration.usecase

import com.leokenzley.kotlinapi.core.ports.`in`.users.*
import com.leokenzley.kotlinapi.core.ports.out.UserRepository
import com.leokenzley.kotlinapi.core.usecase.users.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserUseCaseConfig {
    @Bean
    fun createUserUseCase(userRepository: UserRepository): CreateUserUseCase = CreateUserInteractor(userRepository)

    @Bean
    fun listUsersUseCase(userRepository: UserRepository): ListUsersUseCase = ListUsersInteractor(userRepository)

    @Bean
    fun findUserByIdUseCase(userRepository: UserRepository): com.leokenzley.kotlinapi.core.ports.`in`.users.FindUserByIdUseCase =
        com.leokenzley.kotlinapi.core.usecase.users.FindUserByIdInteractor(userRepository)

    @Bean
    fun deleteUserUseCase(userRepository: UserRepository): DeleteUserUseCase = DeleteUserInteractor(userRepository)

    @Bean
    fun updateUserUseCase(userRepository: UserRepository): UpdateUserUseCase = UpdateUserInteractor(userRepository)

    @Bean
    fun paginationUseCase(userRepository: UserRepository): PaginationUseCase = PaginationUserInteractor(userRepository)

}