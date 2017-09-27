package example.presentation.controller.exception

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {
    @ExceptionHandler(Exception::class)
    fun exception(e: Exception): String {
        println("controller advice: exception Handler")
        println(e.message)
        return "error/exception"
    }
}