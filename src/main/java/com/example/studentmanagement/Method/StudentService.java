package com.example.studentmanagement.Method;

import com.example.studentmanagement.Model.Student;
import com.example.studentmanagement.Repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/")
public class StudentService implements IService {
    private final StudentRepository studentRepository = StudentRepository.getStudentRepository();

    @Override
    @PostMapping(value="create")
    public Object insertStudent(@RequestBody Student student){
        return studentRepository.postStudent(student);
    }

    @Override
    @DeleteMapping(value="delete-by-id")
    public Object deleteById(@RequestBody Map<String,Integer> req){
        return studentRepository.deleteStudentByStudentId(req);
    }

    @Override
    @GetMapping(value="get-all")
    public Object getStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    @GetMapping(value="get-primary")
    public Object primaryStudent(){
        return studentRepository.getPrimaryStudents();
    }

    @Override
    @GetMapping(value="get-faculty")
    public Object facultyStudent(@RequestBody String faculty){
        return studentRepository.getStudentsFromFaculty(faculty);
    }

    @Override
    @GetMapping(value="get-class")
    public Object classStudent(@RequestBody String classRoom){
        return studentRepository.getStudentsFromClass(classRoom);
    }

    @Override
    @GetMapping(value="get-student-id")
    public Object studentById(@RequestBody Map<String, Integer> reqId){
        return studentRepository.getStudentFromStudentId(reqId);
    }

    @Override
    @GetMapping(value="get-low-point")
    public Object studentsLowTrainingPoint(){
        return studentRepository.getStudentsLowTrainingPoint();
    }

    @Override
    @PutMapping(value="update-faculty")
    public Object updateFaculty(@RequestBody Map<String, Integer> reqId, @RequestBody String faculty){
        return studentRepository.updateStudentFaculty(reqId,faculty);
    }

    @Override
    @PutMapping(value="update-class")
    public Object updateClass(@RequestBody Map<String, Integer> reqId,@RequestBody String classRoom){
        return studentRepository.updateStudentClass(reqId,classRoom);
    }

    @Override
    @PutMapping(value="update-address")
    public Object updateAddress(@RequestBody Map<String, Integer> reqId,@RequestBody String address) {
        return studentRepository.updateStudentAddress(reqId,address);
    }

    @Override
    @PutMapping(value="update-accumulate")
    public Object updateAccumulateNumber(@RequestBody Map<String, Integer> req) {
        return studentRepository.updateStudentAccumulateNumber(req);
    }

    @Override
    @PutMapping(value="update-training-point")
    public Object updateTrainingPoint(@RequestBody Map<String, Integer> req) {
        return studentRepository.updateStudentTrainingPoint(req);
    }

    @Override
    @PutMapping(value="update-primary")
    public Object updatePrimary(@RequestBody Map<String, Integer> reqId) {
        return studentRepository.updateStudentPrimary(reqId);
    }

    @Override
    @PutMapping(value="update-number")
    public Object updateNumber(@RequestBody Map<String, Integer> reqId,@RequestBody String number) {
        return studentRepository.updateStudentNumber(reqId,number);
    }
}
