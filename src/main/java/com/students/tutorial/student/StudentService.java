package com.students.tutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
//        return List.of(
//                new Student(1L, "James Bond", "bond@gmail.com", 35, LocalDate.of(1989, Month.JUNE, 10))
//        );

        return studentRepository.findAll();
    }

    // void: The method does not return a value.
    //int: The method returns an integer value.
    //String: The method returns a string value.
    //List<Student>: The method returns a list of Student objects.

    public void addNewStudent(Student student) {

        //The optional provides methods to check for a value, retrieve the value if present, or perform actions if the value is absent. The main purpose of Optional is to avoid null checks and NullPointerExceptions.

      Optional<Student> studentByEmail =   studentRepository.findStudentByEmail(student.getEmail());

      if(studentByEmail.isPresent()){
         throw new IllegalStateException("email is taken");

         // there is no need of the return statement as this method is void, it does not return anything to the user.
//         return;
      }

      studentRepository.save(student);

    }
}
