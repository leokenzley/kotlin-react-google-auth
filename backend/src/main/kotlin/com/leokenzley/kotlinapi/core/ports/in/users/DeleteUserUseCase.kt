package com.leokenzley.kotlinapi.core.ports.`in`.users

interface DeleteUserUseCase {
    fun execute(id: Long)
}