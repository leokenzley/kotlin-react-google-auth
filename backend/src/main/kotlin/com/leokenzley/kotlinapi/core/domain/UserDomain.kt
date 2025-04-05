package com.leokenzley.kotlinapi.core.domain

data class UserDomain(
    val id : Long? = null,
    val name : String,
    val email: String,
    val status: Status = Status.ACTIVE
) {
    enum class Status(val code: String) {
        ACTIVE("A"),
        INACTIVE("I")
    }
}
