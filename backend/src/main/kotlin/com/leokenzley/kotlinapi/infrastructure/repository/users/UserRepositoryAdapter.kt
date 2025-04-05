package com.leokenzley.kotlinapi.infrastructure.repository.users

import com.leokenzley.kotlinapi.core.domain.UserDomain
import com.leokenzley.kotlinapi.core.ports.out.UserRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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

    override fun update(user: UserDomain): UserDomain {
        val entity = UserJpaEntity(
            name = user.name,
            email = user.email,
            status = user.status.code,
            id = user.id
        )
        return jpaRepository.save(entity)
            .let { saved ->
                UserDomain(
                    id = saved.id,
                    name = saved.name,
                    email = saved.email,
                    status = toStatusEnum(saved.status)
                )
            }
    }

    override fun findAll(): List<UserDomain> {
        val users = jpaRepository.findAll().map { user ->
            UserDomain(
                id = user.id,
                name = user.name,
                email = user.email,
                status = toStatusEnum(user.status)
            )
        }

        return users;
    }

    override fun findById(id: Long): UserDomain? {
        val user = jpaRepository.findById(id).orElse(null) ?: return null

        return UserDomain(
            id = user.id,
            name = user.name,
            email = user.email,
            status = toStatusEnum(user.status)
        )
    }

    override fun deleteById(id: Long)  = jpaRepository.deleteById(id)

    override fun getPaginated(pageable: Pageable): Page<UserDomain> {
        return jpaRepository.findAll(pageable)
            .map { user ->
                UserDomain(
                    id = user.id,
                    name = user.name,
                    email = user.email,
                    status = toStatusEnum(user.status)
                )
            }
    }

    private fun toStatusEnum(status: String): UserDomain.Status {
        return when (status) {
            "A" -> UserDomain.Status.ACTIVE
            "I" -> UserDomain.Status.INACTIVE
            else -> throw IllegalArgumentException("Status desconhecido: $status")
        }
    }
}