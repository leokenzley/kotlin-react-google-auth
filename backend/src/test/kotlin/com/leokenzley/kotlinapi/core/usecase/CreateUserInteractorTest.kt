package com.leokenzley.kotlinapi.core.usecase

import com.leokenzley.kotlinapi.core.domain.UserDomain
import com.leokenzley.kotlinapi.core.ports.out.UserRepository
import com.leokenzley.kotlinapi.core.usecase.users.CreateUserInteractor
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CreateUserInteractorTest {
    private val repository = mockk<UserRepository>(relaxed = true)
    private val interactor = CreateUserInteractor(repository)

    @Test
    @DisplayName("should create user successfully")
    fun `should create a user successfully`(){
        val user = UserDomain(
            name = "John Doe",
            email = "joedoe@any.com",
            status = UserDomain.Status.ACTIVE
        )

        every { repository.save(user) } returns user.copy(id = 1L)

        val result = interactor.execute(user)

        assertEquals(1L, result.id)
        assertEquals("John Doe", result.name)
        verify (exactly = 1) { repository.save(user) }
    }

}