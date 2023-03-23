package com.example.studentmanagement.Method;

import com.example.studentmanagement.Model.Req;
import com.example.studentmanagement.Model.Student;
import com.example.studentmanagement.Repository.IStudent;
import com.example.studentmanagement.Repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/")
public class StudentService implements IStudent {
    private final StudentRepository studentRepository = StudentRepository.getStudentRepository();

    @Override
    @PostMapping(value="create")
    public Object postStudent(@RequestBody Student student){
        return studentRepository.postStudent(student);
    }

    @Override
    @DeleteMapping(value="delete-by-id")
    public Object deleteStudentByStudentId(@RequestBody Map<String,Integer> req){
        return studentRepository.deleteStudentByStudentId(req);
    }

    @Override
    @GetMapping(value="get-all")
    public Object getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    @GetMapping(value="get-class")
    public Object getStudentsFromClass(@RequestParam String classRoom){
        return studentRepository.getStudentsFromClass(classRoom);
    }

    @Override
    @GetMapping(value="get-student-id")
    public Object getStudentFromStudentId(@RequestParam Map<String, Integer> req){
        return studentRepository.getStudentFromStudentId(req);
    }

    @Override
    @GetMapping(value="get-low-point")
    public Object getStudentsLowPoint(){
        return studentRepository.getStudentsLowPoint();
    }

    @Override
    @PutMapping(value="update-class")
    public Object updateStudentClass(@RequestBody Req req){
        return studentRepository.updateStudentClass(req);
    }

    @Override
    @PutMapping(value="update-address")
    public Object updateStudentAddress(@RequestBody Req req) {
        return studentRepository.updateStudentAddress(req);
    }

    @Override
    @PutMapping(value="update-training-point")
    public Object updateStudentPoint(@RequestBody Map<String, Integer> req) {
        return studentRepository.updateStudentPoint(req);
    }

    @Override
    @PutMapping(value="update-number")
    public Object updateStudentNumber(@RequestBody Req req) {
        return studentRepository.updateStudentNumber(req);
    }
}
