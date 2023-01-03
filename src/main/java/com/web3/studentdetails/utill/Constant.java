package com.web3.studentdetails.utill;

import java.util.ArrayList;
import java.util.List;

import com.web3.studentdetails.model.StudentDetailsModel;

/**
 * @author DhilipkumarS
 *
 */
public final class Constant {

  private Constant() {
    throw new UnsupportedOperationException();
  }

  /**
   * Used to store Student data.
   */
  public static final List<StudentDetailsModel> STUDENTSLIST
                          = new ArrayList<StudentDetailsModel>();
}
