package com.web3.studentdetails.exception;

public class StudentExceptionHandler extends RuntimeException {

  /**
   * @param message
   */
  public StudentExceptionHandler(final String message) {
    super(message);
  }
}
