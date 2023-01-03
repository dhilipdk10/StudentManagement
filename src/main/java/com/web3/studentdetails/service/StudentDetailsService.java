package com.web3.studentdetails.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.web3.studentdetails.model.StudentDetailsModel;

/**
 * @author DhilipkumarS
 *
 */
@Service
public interface StudentDetailsService {
  /**
   * @return getAllStudent()
   */
  List<StudentDetailsModel> getAllStudent();

  /**
   * @param id
   * @return getById(final int id)
   */
  StudentDetailsModel getById(int id);

  /**
   * @param studentDetail
   * @return (final StudentDetailsModel studentDetail)
   */
  StudentDetailsModel save(StudentDetailsModel studentDetail);

  /**
   * @param studentDetail
   * @param id
   * @return (final StudentDetailsModel studentDetail,int id)
   */
  StudentDetailsModel edit(StudentDetailsModel studentDetail, int id);

  /**
   * @return deleteStudentDetails()
   */
  String deleteStudentDetails();

  /**
   * @param id
   * @return deletIdStudentDetailsModel(final int id)
   */
  String deletIdStudentDetailsModel(int id);

  /**
   * @param gender
   * @param name
   * @param parent
   * @return getRandom(String gender,String name,String parent)
   */
  List<StudentDetailsModel> getRandom(String gender, String name, String parent);

}
