package com.example.studentmanagement.Method;

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
    Object studentById(@RequestBody Map<String, Integer> reqId);
    Object studentsLowTrainingPoint();
    Object updateFaculty(@RequestBody Map<String, Integer> reqId, String faculty);
    Object updateClass(@RequestBody Map<String, Integer> reqId, String classRoom);
    Object updateAddress(@RequestBody Map<String, Integer> reqId, String address);
    Object updateAccumulateNumber(@RequestBody Map<String, Integer> reqId, Map<String, Integer> accumulateNumber);
    Object updateTrainingPoint(@RequestBody Map<String, Integer> reqId, Map<String, Integer> trainingPoint);
    Object updatePrimary(@RequestBody Map<String, Integer> reqId);
    Object updateNumber(@RequestBody Map<String, Integer> reqId, String number);
}
