package com.leokenzley.kotlinapi.infrastructure.repository.users

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaUserRepository : JpaRepository<UserJpaEntity, Long>