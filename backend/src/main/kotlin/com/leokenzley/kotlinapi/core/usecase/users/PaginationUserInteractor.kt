package com.leokenzley.kotlinapi.core.usecase.users

import com.leokenzley.kotlinapi.core.domain.UserDomain
import com.leokenzley.kotlinapi.core.ports.`in`.users.PaginationUseCase
import com.leokenzley.kotlinapi.core.ports.out.UserRepository
import com.leokenzley.kotlinapi.dto.PaginatedUserResponse
import com.leokenzley.kotlinapi.dto.UserResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component

@Component
class PaginationUserInteractor(val userRepository: UserRepository) : PaginationUseCase {
    override fun find(pageable: Pageable): PaginatedUserResponse {
        val pages:Page<UserDomain> = userRepository.getPaginated(pageable)
        val users: List<UserResponse> = pages.content.map { user ->
            UserResponse(
                id = user.id,
                name = user.name,
                email = user.email,
                status = user.status.code
            )
        }
        return PaginatedUserResponse(
            content = users,
            page = pages.number,
            propertySize = pages.size,
            totalElements = pages.totalElements,
            totalPages = pages.totalPages,
            hasNext = pages.hasNext(),
            hasPrevious = pages.hasPrevious()
        )
    }
}