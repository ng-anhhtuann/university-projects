package com.example.studentmanagement.Method;

import com.example.studentmanagement.Model.Student;
import com.example.studentmanagement.Repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/")
public class StudentService {
    private final StudentRepository studentRepository = StudentRepository.getStudentRepository();

    @PostMapping(value="insert")
    public Object insertStudent(@RequestBody Student student){
        return studentRepository.postStudent(student);
    }

    @DeleteMapping(value="delete-by-id")
    public Object deleteById(@RequestBody int studentId){
        return studentRepository.deleteStudentByStudentId(studentId);
    }

}
