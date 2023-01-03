package com.web3.studentdetails.impl;

import com.web3.studentdetails.exception.StudentExceptionHandler;
import com.web3.studentdetails.model.StudentDetailsModel;
import com.web3.studentdetails.repository.StudentRepository;
import com.web3.studentdetails.service.StudentDetailsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DhilipkumarS
 *
 */
@Service
public class StudentDetailsImpl implements StudentDetailsService {
  /**
   *
   */
  @Autowired
  private StudentRepository studentRepository;

  @Override
  public StudentDetailsModel getById(final int id) {
    return studentRepository.findById(id).orElse(null);
  }

  @Override
  public List<StudentDetailsModel> getRandom(final String name, final String gender, final String  parent) {
    List<StudentDetailsModel> studentDetailsModel = studentRepository.findByNameAndGenderAndParent(name, gender, parent);
    return studentDetailsModel;
  }

  @Override
  public StudentDetailsModel save(final StudentDetailsModel studentDetail) {
    return studentRepository.save(studentDetail);
  }

  @Override
  public List<StudentDetailsModel> getAllStudent() {
    return studentRepository.findAll();
  }

  @Override
  public StudentDetailsModel edit(final StudentDetailsModel studentDetail, final int id) {
    boolean isStudentDetailFound = studentRepository.existsById(id);
    if (isStudentDetailFound) {
      studentDetail.setId(id);
      studentRepository.save(studentDetail);
    }
    return studentDetail;
  }

  @Override
  public String deleteStudentDetails() {
   studentRepository.deleteAll();
   return "Delete Successfully";
 }

 @Override
 public String deletIdStudentDetailsModel(final int id) {
   boolean studentExistsId = studentRepository.existsById(id);
   if (studentExistsId) {
     studentRepository.deleteById(id);
     return "Deleted Succesfully";
   } else {
    throw new StudentExceptionHandler("Id is not found");
   }
 }

}

