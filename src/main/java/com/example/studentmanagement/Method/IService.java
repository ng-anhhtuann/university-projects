package com.example.studentmanagement.Method;

import com.example.studentmanagement.Model.Req;
import com.example.studentmanagement.Model.Student;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface IService {
    Object insertStudent(@RequestBody Student student);
    Object deleteById(@RequestBody Map<String,Integer> req);
    Object getStudents();
    Object primaryStudent();
    Object facultyStudent(@RequestBody String faculty);
    Object classStudent(@RequestBody String classRoom);
    Object studentById(@RequestBody Map<String, Integer> req);
    Object studentsLowTrainingPoint();
    Object updateFaculty(@RequestBody Req req);
    Object updateClass(@RequestBody Req req);
    Object updateAddress(@RequestBody Req req);
    Object updateAccumulateNumber(@RequestBody Map<String, Integer> req);
    Object updateTrainingPoint(@RequestBody Map<String, Integer> req);
    Object updatePrimary(@RequestBody Map<String, Integer> req);
    Object updateNumber(@RequestBody Req req);
}
