package com.leokenzley.kotlinapi.application.mapper

import com.leokenzley.kotlinapi.core.domain.UserDomain
import com.leokenzley.kotlinapi.dto.UserRequest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserMapperTest {

    @Test
    fun `should map UserRequest to UserDomain`() {
        val userRequest = UserRequest(name = "John Doe", email = "john.doe@example.com")
        val userDomain = UserMapper.toDomain(userRequest)

        assertEquals("John Doe", userDomain.name)
        assertEquals("john.doe@example.com", userDomain.email)
        assertEquals(UserDomain.Status.ACTIVE, userDomain.status)
    }

    @Test
    fun `should map UserDomain to UserResponse`() {
        val userDomain = UserDomain(id = 1L, name = "John Doe", email = "john.doe@example.com", status = UserDomain.Status.ACTIVE)
        val userResponse = UserMapper.toResponse(userDomain)

        assertEquals(1L, userResponse.id)
        assertEquals("John Doe", userResponse.name)
        assertEquals("john.doe@example.com", userResponse.email)
        assertEquals("A", userResponse.status)
    }
}