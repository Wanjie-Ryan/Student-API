package com.students.tutorial.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

//mapping the student model to a table in the DB using Java Persistence API
@Entity
// entity annotation specifies that this class is an entity and is mapped to a DB

@Table
//This annotation specifies the table in the database with which the entity is mapped. If you don't specify a name, the table name will default to the class name.
public class Student {

    @Id
    // This annotation specifies the primary key of the entity.
    @SequenceGenerator(name= "student_sequence", sequenceName ="student_sequence", allocationSize =1)
    //This means that each time a new Student entity is created, the sequence will generate a new ID by incrementing the previous value by 1.
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private String email;
    @Transient
    // transient means that the age column will not be created in the DB
    private Integer age;
    private LocalDate dob;

    public Student(){

    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    // this one has no id because the db will generate an id for us
    public Student( String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        // calculating the age from the DOB
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                '}';
    }
}
