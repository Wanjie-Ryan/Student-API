package com.students.tutorial.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    //used for dependency injection. It allows Spring to automatically inject the required dependencies into a class.
    //In this example, @Autowired is used on the constructor of the StudentController class. This means that when Spring creates an instance of StudentController, it will automatically inject an instance of StudentService into it.
    //Constructor injection is generally preferred because it makes it clear that the class cannot work without the required dependencies.
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping

    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(Student student){
        studentService.addNewStudent(student);
    }


}
