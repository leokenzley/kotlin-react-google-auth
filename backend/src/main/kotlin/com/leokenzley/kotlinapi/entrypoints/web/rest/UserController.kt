package com.leokenzley.kotlinapi.entrypoints.web.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController() {

    @GetMapping
    fun getAllUsers(): List<String> {
        return listOf("User1", "User2", "User3")
    }
}