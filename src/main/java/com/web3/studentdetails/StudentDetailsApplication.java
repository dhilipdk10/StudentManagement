package com.web3.studentdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DhilipkumarS
 *
 */
@SpringBootApplication
public class StudentDetailsApplication {
  /**
   * @param args
   */
  public static void main(final String[] args) {
    SpringApplication.run(StudentDetailsApplication.class, args);
  }

  /**
   * Dummy method to suppress the checkstyle warning
   * for <b>Utility classes should not have a public or default constructor</b>.
   */
  public void foo() {
    throw new UnsupportedOperationException();
  }
}
