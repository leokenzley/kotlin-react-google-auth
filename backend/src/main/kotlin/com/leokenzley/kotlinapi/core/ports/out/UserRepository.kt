package com.leokenzley.kotlinapi.core.ports.out

import com.leokenzley.kotlinapi.core.domain.UserDomain
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface UserRepository {
    fun save(user: UserDomain): UserDomain
    fun update(user: UserDomain): UserDomain
    fun findAll(): List<UserDomain>
    fun findById(id: Long): UserDomain?
    fun deleteById(id: Long)
    fun getPaginated(pageable: Pageable): Page<UserDomain>
}