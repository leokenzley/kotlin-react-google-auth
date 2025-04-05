package com.leokenzley.kotlinapi.core.ports.`in`.users

import com.leokenzley.kotlinapi.dto.PaginatedUserResponse
import org.springframework.data.domain.Pageable

interface PaginationUseCase {
    fun find(pageable: Pageable): PaginatedUserResponse
}