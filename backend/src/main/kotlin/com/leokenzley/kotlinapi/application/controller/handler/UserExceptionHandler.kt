package com.leokenzley.kotlinapi.application.controller.handler

import com.leokenzley.kotlinapi.core.usecase.handler.exception.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(ex: UserNotFoundException): ResponseEntity<ProblemDetail> {
        val problemDetail =
            ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.message);

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(problemDetail)
    }
}