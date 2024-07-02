package com.students.tutorial.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// this class is responsible for data access
@Repository
// over here you specify the type of object you want your interface to work with and the Data type for the ID, in our case the id is of data type Long
public interface StudentRepository extends JpaRepository<Student, Long> {


    // In the @Query annotation, ?1 is a placeholder for the first method parameter. It indicates that the first parameter in the method signature should be used in the query at that position. In this case, ?1 is replaced with the value of the email parameter when the method findStudentByEmail is called.
    // s is an alias
//    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    // this is a custom method that will be used to find students by their emails.
    Optional<Student> findStudentByEmail(String email);


}
