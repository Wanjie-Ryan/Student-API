package com.students.tutorial.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(1L, "James Bond", "bond@gmail.com", 35, LocalDate.of(1989, Month.JUNE, 10))
        );
    }
}
