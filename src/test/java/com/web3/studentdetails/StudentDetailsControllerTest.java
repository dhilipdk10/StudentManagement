package com.web3.studentdetails;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.web3.studentdetails.model.StudentDetailsModel;
import net.minidev.json.JSONObject;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentDetailsControllerTest {

  @Autowired
  private TestRestTemplate testRestTemplate;
  
  int id = -1;
  
  @Test
  @Order(1)
  @DisplayName("Save Student Details ")
  void saveStudentDetailsController() {
    
    //Arrange
    JSONObject StudentDetailsJsonObject =new JSONObject();
    //StudentDetailsJsonObject.put("id", 1);
    StudentDetailsJsonObject.put("name", "ajs");
    StudentDetailsJsonObject.put("parent", "qhh");
    StudentDetailsJsonObject.put("gender", "male");
    StudentDetailsJsonObject.put("emailId", "ssjj@gmail.com");
    StudentDetailsJsonObject.put("standard", 1);
    StudentDetailsJsonObject.put("phone", 1234567890l);
    StudentDetailsJsonObject.put("address", "dnhndjhdndj");
    StudentDetailsJsonObject.put("dateOfBirth", "10-4-2001");

    HttpHeaders headers =new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    
    HttpEntity<String> request= new HttpEntity<String>(StudentDetailsJsonObject.toString(),headers);
    
    //Act
    ResponseEntity<StudentDetailsModel> createdStudentDetailsEntity=testRestTemplate.postForEntity("/save", request, StudentDetailsModel.class);
    StudentDetailsModel createdStudentDetails=createdStudentDetailsEntity.getBody();
    
    //Assertion
    
  Assertions.assertEquals(HttpStatus.OK, createdStudentDetailsEntity.getStatusCode());
  id=createdStudentDetails.getId();

  assertEquals(StudentDetailsJsonObject.getAsString("name"), createdStudentDetails.getName()
      ,"Return Student's name is incorect");
  assertEquals(StudentDetailsJsonObject.getAsString("parent"), createdStudentDetails.getParent()
      ,"Return Student's parent is incorect");
  assertEquals(StudentDetailsJsonObject.getAsString("gender"), createdStudentDetails.getGender()
      ,"Return Student's gender is incorect");
  assertEquals(StudentDetailsJsonObject.getAsString("emailId"), createdStudentDetails.getEmailId()
      ,"Return Student's emailId is incorect");
  assertEquals(StudentDetailsJsonObject.getAsNumber("standard"), createdStudentDetails.getStandard()
      ,"Return Student's standard is incorect");
  assertEquals(StudentDetailsJsonObject.getAsNumber("phone"), createdStudentDetails.getPhone()
      ,"Return Student's phone is incorect");
  assertEquals(StudentDetailsJsonObject.getAsString("address"), createdStudentDetails.getAddress()
      ,"Return Student's address is incorect");
  assertEquals(StudentDetailsJsonObject.getAsString("dateOfBirth"), createdStudentDetails.getDateOfBirth()
      ,"Return Student's dateOfBirth is incorect");
  }
  @Test
  @Order(2)
  @DisplayName("Get Student Details ")
  void getStudentDetails_validInformation() {
    //Arrange
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");
    
    HttpEntity requestEntity = new HttpEntity(null,headers);
    
    //Act
    ResponseEntity<List<StudentDetailsModel>> response = testRestTemplate.exchange("/get", 
        HttpMethod.GET,
        requestEntity,
        new ParameterizedTypeReference<List<StudentDetailsModel>> () {
        });
    
    //Assert
    String actualStatusCode =response.getStatusCode().toString();
    assertEquals(HttpStatus.OK, response.getStatusCode(), "Expected 200 but got "+actualStatusCode);
  }
  
  @Test
  @Order(3)
  @DisplayName("Get by Id Student Details")
  void getByIdStudentDetails() {
    //Arrange
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");
    
    HttpEntity requestEntity = new HttpEntity(null,headers);
    
    //Act
    
    ResponseEntity<StudentDetailsModel> response = testRestTemplate.exchange("/get/"+id, 
        HttpMethod.GET,
        requestEntity,
        new ParameterizedTypeReference<StudentDetailsModel> () {
        });
    //Assert
    String actualStatusCode = response.getStatusCode().toString();
    assertEquals(HttpStatus.OK, response.getStatusCode(), "Expected 200 but got:"+actualStatusCode);
  }
  

  @Test
  @Order(4)
  @DisplayName("Update Student Details")
  void updateStudentDetails_ValidInformation() {
    
    //Arrange
    JSONObject updateStudentDetails =new JSONObject();
    updateStudentDetails.put("id", id);
    updateStudentDetails.put("name", "raj");
    updateStudentDetails.put("parent", "kumar");
    updateStudentDetails.put("gender", "male");
    updateStudentDetails.put("emailId", "raj@gmail.com");
    updateStudentDetails.put("standard", 1);
    updateStudentDetails.put("phone", 1234567890l);
    updateStudentDetails.put("address", "dnhndjhdndj");
    updateStudentDetails.put("dateOfBirth", "10-4-2001");
    HttpHeaders headers =new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    
    HttpEntity<String> request= new HttpEntity<String>(updateStudentDetails.toString(),headers);
    ResponseEntity<StudentDetailsModel> updateStudentDetailsEntity=testRestTemplate.exchange("/update/"+id, HttpMethod.PUT,request, StudentDetailsModel.class);
    StudentDetailsModel createdStudentDetails=updateStudentDetailsEntity.getBody();
    
    //Act
    Assertions.assertEquals(HttpStatus.OK, updateStudentDetailsEntity.getStatusCode());
    assertEquals(updateStudentDetails.getAsString("name"), createdStudentDetails.getName()
        ,"Return Student's name is incorect");
    assertEquals(updateStudentDetails.getAsNumber("id"), createdStudentDetails.getId(),"Student Id is invalid");
  }
  @Disabled
  @Test
  @Order(5)
  @DisplayName("Delete Student Details")
  void deleteStudentDetails() {
    //Arrange
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");
    
    HttpEntity requestEntity = new HttpEntity(id,headers);
    
    //Act
    ResponseEntity<String> response = testRestTemplate.exchange("/delete", 
        HttpMethod.DELETE,
        requestEntity,
        new ParameterizedTypeReference<String> () {
        });
    
    //Assert
    String actualStatusCode = response.getStatusCode().toString();
    assertEquals(HttpStatus.OK, response.getStatusCode(),"Expected 200 but got:"+actualStatusCode);
  }
  @Disabled
  @Test
  @Order(6)
  @DisplayName("Delet by id Student Details")
  void deleteByIdStudentDetails() {
    //Arrange
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");
    
    HttpEntity requestEntity = new HttpEntity(null,headers);
    
    //Act
    ResponseEntity<String> response = testRestTemplate.exchange("/delete/1", 
        HttpMethod.DELETE,
        requestEntity,
        new ParameterizedTypeReference<String> () {
        });
    
    //Assert
    String actualStatusCode =response.getStatusCode().toString();
    assertEquals(HttpStatus.OK, response.getStatusCode(),"Expected 200 but got"+actualStatusCode);
  }
  @Disabled
  @Test
  @Order(7)
  @DisplayName("Id not found")
  void deleteStudentDetails_invalidDetails() {
    //Arrange
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");
    
    HttpEntity requestEntity = new HttpEntity(null,headers);
    
    //Act
    ResponseEntity<String> response = testRestTemplate.exchange("/delete/6464", 
        HttpMethod.DELETE,
        requestEntity,
        new ParameterizedTypeReference<String> () {
        });
    
    //Assert
    String actualStatusCode =response.getStatusCode().toString();
    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(),"Expected 200 but got"+actualStatusCode);
  }
}
