package com.example.studentmanagement.Config;

import com.example.studentmanagement.Method.StudentService;
import com.example.studentmanagement.Repository.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public StudentRepository studentRepository() {
        return StudentRepository.getStudentRepository();
    }

    @Bean
    public StudentService studentService(StudentRepository studentRepository) {
        return new StudentService(studentRepository);
    }
}
