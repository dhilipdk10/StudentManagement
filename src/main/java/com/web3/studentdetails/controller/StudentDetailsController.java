package com.web3.studentdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web3.studentdetails.model.StudentDetailsModel;
import com.web3.studentdetails.service.StudentDetailsService;


/** editStudentDetails.
 */
@RestController
public class StudentDetailsController {

  /**
   *
   */
  @Autowired
  private StudentDetailsService studentDetailsService;
  /** editStudentDetails.
   *
   * @return studentDetailsService.getAllStudent()
   */

  @GetMapping("/get")
  public List<StudentDetailsModel> getAllStudent() {
    return studentDetailsService.getAllStudent();
  }
  /**
   * @param name
   * @param gender
   * @param parent
   * @return studentDetails
   */

  @GetMapping("/get/name/{name}/gender/{gender}/parent/{parent}")
  public List<StudentDetailsModel> getGender(@PathVariable("name") final String name, @PathVariable("gender") final String gender, @PathVariable("parent") final String parent) {
    List<StudentDetailsModel> studentDetails = studentDetailsService.getRandom(name, gender, parent);
    return studentDetails;
  }

  /**
   * @param id
   * @return students
   */

  @GetMapping("/get/{id}")
 public StudentDetailsModel getId(@PathVariable final int id) {
   var students = studentDetailsService.getById(id);
   return students;
  }

  /**
   * @param studentDetails
   * @return studentDetailsService.save(studentDetails)
   */
  @PostMapping("/save")
  public StudentDetailsModel save(@RequestBody final StudentDetailsModel studentDetails) {
    return studentDetailsService.save(studentDetails);
  }

 /**
 * @param id
 * @param studentDetails
 * @return  studentDetailsService.edit(studentDetails, id)
 */
@PutMapping("/update/{id}")
  public StudentDetailsModel edit(@PathVariable  final int id, @RequestBody final StudentDetailsModel studentDetails) {
   return studentDetailsService.edit(studentDetails, id);
  }

  /**
   * @return studentDetailsService.deleteStudentDetails();
   */
  @DeleteMapping("/delete")
 public String deleteStudentDetails() {
    return studentDetailsService.deleteStudentDetails();
  }
 /**
 * @param id
 * @return studentDetailsService.deletIdStudentDetailsModel(id)
 */

@DeleteMapping("/delete/{id}")
  public String deleteIdStudentDetails(@PathVariable final int id) {
    return studentDetailsService.deletIdStudentDetailsModel(id);
  }
}
