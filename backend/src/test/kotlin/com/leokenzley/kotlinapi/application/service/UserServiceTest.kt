package com.leokenzley.kotlinapi.application.service

 import com.leokenzley.kotlinapi.core.domain.UserDomain
 import com.leokenzley.kotlinapi.core.ports.`in`.users.CreateUserUseCase
 import com.leokenzley.kotlinapi.core.ports.`in`.users.ListUsersUseCase
 import com.leokenzley.kotlinapi.dto.UserRequest
 import com.leokenzley.kotlinapi.dto.UserResponse
 import io.mockk.every
 import io.mockk.mockk
 import io.mockk.verify
 import org.junit.jupiter.api.Assertions.assertEquals
 import org.junit.jupiter.api.Test

class UserServiceTest {

     private val createUserUseCase: CreateUserUseCase = mockk()
     private val listUsersUseCase: ListUsersUseCase = mockk()

    private val userService =  UserService(
         createUserUseCase = createUserUseCase,
         listUsersUseCase = listUsersUseCase,
         findUserByIdUseCase = mockk(),
         deleteUserUseCase = mockk(),
         paginationUseCase = mockk()
     )

     @Test
     fun `should create user successfully`() {
         // Arrange
         val userRequest = UserRequest(name = "John Doe", email = "john.doe@example.com")
         val userDomain = UserDomain(name = "John Doe", email = "john.doe@example.com", status = UserDomain.Status.ACTIVE)
         val createdUser = userDomain.copy(id = 1L)
         val userResponse = UserResponse(id = 1L, name = "John Doe", email = "john.doe@example.com", status = "A")

         every { createUserUseCase.execute(any()) } returns createdUser

         // Act
         val result = userService.createUser(userRequest)

         // Assert
         assertEquals(userResponse, result)
         verify { createUserUseCase.execute(userDomain) }
     }

    @Test
    fun `should list users successfully`() {
        // Arrange
        val userDomain1 = UserDomain(id = 1L, name = "John Doe", email = "john.doe@example.com", status = UserDomain.Status.ACTIVE)
        val userDomain2 = UserDomain(id = 2L, name = "Jane Doe", email = "jane.doe@example.com", status = UserDomain.Status.INACTIVE)
        val userResponse1 = UserResponse(id = 1L, name = "John Doe", email = "john.doe@example.com", status = "A")
        val userResponse2 = UserResponse(id = 2L, name = "Jane Doe", email = "jane.doe@example.com", status = "I")

        every { listUsersUseCase.find() } returns listOf(userDomain1, userDomain2)

        // Act
        val result = userService.listUsers()

        // Assert
        assertEquals(listOf(userResponse1, userResponse2), result)
    }
 }