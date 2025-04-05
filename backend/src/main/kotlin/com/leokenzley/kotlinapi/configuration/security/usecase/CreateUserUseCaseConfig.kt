package com.leokenzley.kotlinapi.configuration.security.usecase

import com.leokenzley.kotlinapi.core.ports.`in`.users.CreateUserUseCase
import com.leokenzley.kotlinapi.core.ports.out.UserRepository
import com.leokenzley.kotlinapi.core.usecase.users.CreateUserInteractor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CreateUserUseCaseConfig {
    @Bean
    fun createUserUseCase(userRepository: UserRepository): CreateUserUseCase {
        return CreateUserInteractor(userRepository)
    }
}