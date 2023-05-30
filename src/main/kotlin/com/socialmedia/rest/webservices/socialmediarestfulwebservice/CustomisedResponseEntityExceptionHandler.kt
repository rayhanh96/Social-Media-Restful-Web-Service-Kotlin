package com.socialmedia.rest.webservices.socialmediarestfulwebservice

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class CustomisedResponseEntityExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<Any> {

        val errorDetails = ErrorDetails(LocalDateTime.now(), mutableListOf((ex.message.toString())), request.getDescription(false))

        return ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundExceptions(ex: Exception, request: WebRequest): ResponseEntity<Any> {

        val errorDetails = ErrorDetails(LocalDateTime.now(), mutableListOf(ex.message.toString()), request.getDescription(false))

        return ResponseEntity(errorDetails, HttpStatus.NOT_FOUND)
    }

    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException, headers: HttpHeaders, status: HttpStatusCode, request: WebRequest): ResponseEntity<Any>? {

        val errorMessages = mutableListOf<String?>()
        ex.fieldErrors.map { it.defaultMessage }.toCollection(errorMessages)

        val errorDetails = ErrorDetails(LocalDateTime.now(), errorMessages, request.getDescription(false))

        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }
}
