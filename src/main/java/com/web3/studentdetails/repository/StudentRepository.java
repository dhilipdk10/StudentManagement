package com.web3.studentdetails.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web3.studentdetails.model.StudentDetailsModel;

/**
 * @author DhilipkumarS
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentDetailsModel, Integer> {
  /**
   * @param name
   * @param gender
   * @param parent
   * @return (String name,String gender,String parent)
   */
  List<StudentDetailsModel> findByNameAndGenderAndParent(String name, String gender, String parent);

  /**
   * @param id
   * @return id
   */
  boolean existsById(int id);
}
