package com.students.tutorial.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// this class is responsible for data access
@Repository
// over here you specify the type of object you want your interface to work with and the Data type for the ID, in our case the id is of data type Long
public interface StudentRepository extends JpaRepository<Student, Long> {




}
