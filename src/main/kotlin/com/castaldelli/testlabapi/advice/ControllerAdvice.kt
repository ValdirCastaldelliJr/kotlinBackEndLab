package com.castaldelli.testlabapi.advice

import com.fasterxml.jackson.core.JsonParseException
import javassist.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(JsonParseException::class)
    fun jsonParseExceptionHandler(request: HttpServletRequest, response: HttpServletResponse, e: Exception): ResponseEntity<String> {
        return ResponseEntity("Bad request", HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(NumberFormatException::class)
    fun numberFormatExceptionHandler(request: HttpServletRequest, response: HttpServletResponse, e: Exception): ResponseEntity<String> {
        return ResponseEntity("Bad request", HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(JpaObjectRetrievalFailureException::class)
    fun jpaObjectRetrievalFailureExceptionHandler(request: HttpServletRequest, response: HttpServletResponse, e: Exception): ResponseEntity<String> {
        return ResponseEntity("Not Found", HttpStatus.NOT_FOUND)
    }

}