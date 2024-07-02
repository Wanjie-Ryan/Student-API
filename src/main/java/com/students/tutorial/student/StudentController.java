package com.students.tutorial.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    // requestBody means that we are taking the data from the client request in the FE and we are converting it into a student object
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")

    public void deleteStudent(@PathVariable("studentId") Long id){

        studentService.deleteStudent(id);

    }

    @PutMapping(path="{studentId}")

        //Flexibility in Parameters: Using @RequestParam allows you to make these parameters optional (required = false). This means that clients can choose to update only name, only email, or both without encountering errors due to missing parameters.
    public void updateStudent(@PathVariable("studentId") Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email ){

        studentService.updateStudents(id, name, email);

    }


}
