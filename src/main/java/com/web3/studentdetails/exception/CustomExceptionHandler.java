package com.web3.studentdetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.google.gson.JsonObject;

/**
 * @author DhilipkumarS
 *
 */
@ControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler {

  /**
   * @param studentException
   * @return ResponseEntity<String>
   */
  @ExceptionHandler(StudentExceptionHandler.class)
  public ResponseEntity<String> studentException(final StudentExceptionHandler studentException) {
    JsonObject jsonObject = new JsonObject();
    String message = studentException.getMessage();
    jsonObject.addProperty("errorMessage", message);

    return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.NOT_FOUND);
    }

}
