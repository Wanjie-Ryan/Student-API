package com.students.tutorial.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Bond = new Student("James Bond", "bond@gmail.com",  LocalDate.of(1989, Month.JUNE, 10));
            Student alex = new Student("Alexis Leki", "alex@gmail.com",  LocalDate.of(1989, Month.JUNE, 10));

            repository.saveAll(List.of(Bond, alex));
        };
    }
}
