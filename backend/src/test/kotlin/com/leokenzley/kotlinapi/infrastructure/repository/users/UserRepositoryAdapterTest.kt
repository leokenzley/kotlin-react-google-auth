package com.leokenzley.kotlinapi.infrastructure.repository.users

import com.leokenzley.kotlinapi.core.domain.UserDomain
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserRepositoryAdapterTest {
    private val jpaRepository = mockk<JpaUserRepository>()
    private val userRepositoryAdapter = UserRepositoryAdapter(jpaRepository)

    @Test
    fun `should return all users`() {
        // Arrange
        val userJpaEntity1 = UserJpaEntity(id = 1L, name = "John Doe", email = "john.doe@example.com", status = "A")
        val userJpaEntity2 = UserJpaEntity(id = 2L, name = "Jane Doe", email = "jane.doe@example.com", status = "I")
        every { jpaRepository.findAll() } returns listOf(userJpaEntity1, userJpaEntity2)

        // Act
        val users = userRepositoryAdapter.findAll()

        // Assert
        assertEquals(2, users.size)
        assertEquals(
            UserDomain(
                id = 1L,
                name = "John Doe",
                email = "john.doe@example.com",
                status = UserDomain.Status.ACTIVE
            ), users[0]
        )
        assertEquals(
            UserDomain(
                id = 2L,
                name = "Jane Doe",
                email = "jane.doe@example.com",
                status = UserDomain.Status.INACTIVE
            ), users[1]
        )
    }
}