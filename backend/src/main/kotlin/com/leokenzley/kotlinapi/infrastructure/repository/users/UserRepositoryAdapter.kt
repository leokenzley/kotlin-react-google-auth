package com.leokenzley.kotlinapi.infrastructure.repository.users

import com.leokenzley.kotlinapi.core.domain.UserDomain
import com.leokenzley.kotlinapi.core.ports.out.UserRepository
import org.springframework.stereotype.Component

@Component
class UserRepositoryAdapter(
    private val jpaRepository: JpaUserRepository
) : UserRepository {
    override fun save(user: UserDomain): UserDomain {
        val entity = UserJpaEntity(
            name = user.name,
            email = user.email,
            status = user.status.code
        )
        val saved = jpaRepository.save(entity)
        return user.copy(id = saved.id)
    }
}