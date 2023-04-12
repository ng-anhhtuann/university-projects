package com.example.studentmanagement.Method;

import com.example.studentmanagement.Model.DoubleReq;
import com.example.studentmanagement.Model.Req;
import com.example.studentmanagement.Model.Student;
import com.example.studentmanagement.Repository.IStudent;
import com.example.studentmanagement.Repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.example.studentmanagement.Utils.Utilities.getResultFromFuture;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/")
public class StudentService implements IStudent {
    private final StudentRepository studentRepository = StudentRepository.getStudentRepository();
    private final ExecutorService executorService = Executors.newFixedThreadPool(100);

    @Override
    @GetMapping(value="get-all")
    public Object getAllStudents() {
        Future<Object> future = executorService.submit(studentRepository::getAllStudents);
        return getResultFromFuture(future);
    }

    @Override
    @DeleteMapping(value="delete-by-id")
    public Object deleteStudentByStudentId(@RequestBody Map<String,Integer> req){
        Future<Object> future = executorService.submit(() -> studentRepository.deleteStudentByStudentId(req));
        return getResultFromFuture(future);
    }

    @Override
    @PostMapping(value="create")
    public Object postStudent(@RequestBody Student student){
        Future<Object> future = executorService.submit(() -> studentRepository.postStudent(student));
        return getResultFromFuture(future);
    }

    @Override
    @GetMapping(value="get-class")
    public Object getStudentsFromClass(@RequestParam String classRoom){
        Future<Object> future = executorService.submit(() -> studentRepository.getStudentsFromClass(classRoom));
        return getResultFromFuture(future);
    }

    @Override
    @GetMapping(value="get-student-id")
    public Object getStudentFromStudentId(@RequestParam Map<String, Integer> req){
        Future<Object> future = executorService.submit(() -> studentRepository.getStudentFromStudentId(req));
        return getResultFromFuture(future);
    }

    @Override
    @GetMapping(value="get-low-point")
    public Object getStudentsLowPoint(){
        Future<Object> future = executorService.submit(studentRepository::getStudentsLowPoint);
        return getResultFromFuture(future);
    }

    @Override
    @PutMapping(value="update-class")
    public Object updateStudentClass(@RequestBody Req req){
        Future<Object> future = executorService.submit(() -> studentRepository.updateStudentClass(req));
        return getResultFromFuture(future);
    }

    @Override
    @PutMapping(value="update-address")
    public Object updateStudentAddress(@RequestBody Req req) {
        Future<Object> future = executorService.submit(() -> studentRepository.updateStudentAddress(req));
        return getResultFromFuture(future);
    }

    @Override
    @PutMapping(value="update-point")
    public Object updateStudentPoint(@RequestBody DoubleReq req) {
        Future<Object> future = executorService.submit(() -> studentRepository.updateStudentPoint(req));
        return getResultFromFuture(future);
    }

    @Override
    @PutMapping(value="update-number")
    public Object updateStudentNumber(@RequestBody Req req) {
        Future<Object> future = executorService.submit(() -> studentRepository.updateStudentNumber(req));
        return getResultFromFuture(future);
    }
}
