package com.mruruc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
/**
 * Global Exception Handling:
 * Instead of handling exceptions in each controller,
 * you can define a global handler that captures exceptions and formats responses in a consistent manner.
 *
 * Model Attributes:
 * You can define @ModelAttribute methods within a @ControllerAdvice class,
 * and these attributes will be globally available for all controllers, thereby reducing repetition.
 *
 * Data Binding:
 * You can define global @InitBinder methods to customize request parameter data binding.
 * For instance, you might want to register custom property editors for certain data types.
 */
public class GlobalExceptionHandling {
    @ExceptionHandler({NotFoundException.class})
    /**
     *the @ExceptionHandler is an annotation that can be applied to a method within
     *a @Controller or @RestController to indicate that this method should handle exceptions to a specified type.
     */
    public ResponseEntity<ErrorObject> exceptionHandler(NotFoundException ex, WebRequest request){
        ErrorObject errorObject=new ErrorObject();
        errorObject.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorObject.setErrorMessage(ex.getMessage());
        errorObject.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorObject,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler( Exception.class)

    public ResponseEntity<ErrorObject> globalExceptionHandler(Exception ex, WebRequest request){
        ErrorObject errorObject=new ErrorObject();
        errorObject.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorObject.setErrorMessage(ex.getMessage());
        errorObject.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorObject,HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
