package com.web3.studentdetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author DhilipkumarS
 *
 */
@Entity
@Table(name = "StudentsDetails")
public class StudentDetailsModel {
  /**
   * pojoclass of student Id.
   */
  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stud_id_sequence")
  @SequenceGenerator(name = "stud_id_sequence", sequenceName = "STUD_ID_SEQ", allocationSize = 1)
  private int id;

  /**
   * standard of student details in pojo class.
   */
  @Column(name = "standard", nullable = false)
  private int standard;
  /**
   *phone number of student detils in pojo class.
   */
  @Column(name = "phone")
  private long phone;
  /**
   *Student name of pojo class.
   */
  @Column(name = "name")
  private String name;
  /**
   *Student gender of the pojoclass.
   */
  @Column(name = "gender")
  private String gender;
  /**
   *student parent name of the pojoclass.
   */
  @Column(name = "parent")
  private String parent;
  /**
   *student emailId of the pojoclass.
   */
  @Column(name = "emailId")
  private String emailId;
  /**
   *student address of the pojoclass.
   */
  @Column(name = "address")
  private String address;
  /**
   *student date of birth of the pojoclass.
   */
  @Column(name = "dateOfBirth")
  private String dateOfBirth;

  /**
   * @return id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * @return standard
   */
  public int getStandard() {
    return standard;
  }

  /**
   * @param standard
   */
  public void setStandard(final int standard) {
    this.standard = standard;
  }

  /**
   * @return phone
   */
  public long getPhone() {
    return phone;
  }

  /**
   * @param phone
   */
  public void setPhone(final long phone) {
    this.phone = phone;
  }

  /**
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * @return gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * @param gender
   */
  public void setGender(final String gender) {
    this.gender = gender;
  }

  /**
   * @return parent
   */
  public String getParent() {
    return parent;
  }

  /**
   * @param parent
   */
  public void setParent(final String parent) {
    this.parent = parent;
  }

  /**
   * @return emailId
   */
  public String getEmailId() {
    return emailId;
  }

  /**
   * @param emailId
   */
  public void setEmailId(final String emailId) {
    this.emailId = emailId;
  }

  /**
   * @return address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address
   */
  public void setAddress(final String address) {
    this.address = address;
  }

  /**
   * @return dateOfBirth
   */
  public String getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * @param dateOfBirth
   */
  public void setDateOfBirth(final String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

}
