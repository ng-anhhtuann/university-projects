package com.example.studentmanagement.Repository;

import com.example.studentmanagement.Model.Req;
import com.example.studentmanagement.Model.Student;

import java.util.Map;

public interface IStudent {
    Object postStudent(Student student);
    Object deleteStudentByStudentId(Map<String,Integer> req);
    Object getAllStudents();
    Object getPrimaryStudents();
    Object getStudentsFromFaculty(String faculty);
    Object getStudentsFromClass(String classRoom);
    Object getStudentFromStudentId(Map<String, Integer> req);
    Object getStudentsLowTrainingPoint();
    Object updateStudentFaculty(Req req);
    Object updateStudentClass(Req req);
    Object updateStudentPrimary(Map<String, Integer> req);
    Object updateStudentTrainingPoint(Map<String, Integer> req);
    Object updateStudentAddress(Req req);
    Object updateStudentNumber(Req req);
    Object updateStudentAccumulateNumber(Map<String, Integer> req);
}
