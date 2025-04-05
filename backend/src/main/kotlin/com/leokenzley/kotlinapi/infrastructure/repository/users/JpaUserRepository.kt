package com.leokenzley.kotlinapi.infrastructure.repository.users

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaUserRepository : CrudRepository<UserJpaEntity, Long>, PagingAndSortingRepository<UserJpaEntity, Long>