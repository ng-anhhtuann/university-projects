package com.example.studentmanagement.Repository;

import com.example.studentmanagement.Model.DoubleReq;
import com.example.studentmanagement.Model.Req;
import com.example.studentmanagement.Model.Student;

import java.util.Map;

public interface IStudent {
    Object postStudent(Student student);
    Object deleteStudentByStudentId(Map<String,Integer> req);
    Object getAllStudents();
    Object getStudentsFromClass(String classRoom);
    Object getStudentFromStudentId(Map<String, Integer> req);
    Object getStudentsLowPoint();
    Object updateStudentClass(Req req);
    Object updateStudentPoint(DoubleReq req);
    Object updateStudentAddress(Req req);
    Object updateStudentNumber(Req req);
}