package com.example.studentmanagement.Repository;

import com.example.studentmanagement.Model.Student;

public interface IStudent {
    Object postStudent(Student student);
    Object deleteStudentByStudentId(int studentId);
    Object getPrimaryStudents();
    Object getStudentsFromFaculty(String faculty);
    Object getStudentsFromClass(String classRoom);
    Object getStudentFromStudentId(int studentId);
    Object getStudentsFromTrainingPointInRange(int start, int end);
    Object updateStudentFaculty(int studentId, String faculty);
    Object updateStudentClass(int studentId, String classRoom);
    Object updateStudentPrimary(int studentId);
    Object updateStudentTrainingPoint(int studentId, int trainingPoint);
    Object updateStudentAddress(int studentId, String address);
    Object updateStudentNumber(int studentId, String number);
    Object updateStudentAccumulateNumber(int studentId, int accumulateNumber);
}
