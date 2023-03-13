package com.example.studentmanagement.Repository;

import com.example.studentmanagement.Model.Student;

import java.util.Map;

public interface IStudent {
    Object postStudent(Student student);
    Object deleteStudentByStudentId(Map<String,Integer> req);
    Object getAllStudents();
    Object getPrimaryStudents();
    Object getStudentsFromFaculty(String faculty);
    Object getStudentsFromClass(String classRoom);
    Object getStudentFromStudentId(Map<String, Integer> reqId);
    Object getStudentsLowTrainingPoint();
    Object updateStudentFaculty(Map<String, Integer> reqId, String faculty);
    Object updateStudentClass(Map<String, Integer> reqId, String classRoom);
    Object updateStudentPrimary(Map<String, Integer> reqId);
    Object updateStudentTrainingPoint(Map<String, Integer> reqId, Map<String, Integer> point);
    Object updateStudentAddress(Map<String, Integer> reqId, String address);
    Object updateStudentNumber(Map<String, Integer> reqId, String number);
    Object updateStudentAccumulateNumber(Map<String, Integer> reqId, Map<String, Integer> accumulate);
}
