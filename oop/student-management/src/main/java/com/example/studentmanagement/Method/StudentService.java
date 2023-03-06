package com.example.studentmanagement.Method;

import com.example.studentmanagement.Model.Response;
import com.example.studentmanagement.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudent{

    public static StudentService studentService = new StudentService();

    public static List<Student> studentList = new ArrayList<>();

    public StudentService getStudentService(){
        if (studentService == null){
            studentService = new StudentService();
            studentList = new ArrayList<>();
        }
        return studentService;
    }

    @Override
    public Object postStudent(Student student) {
        if (student.getName().equals("") ||
            student.getNumber().equals("") ||
            student.getStudentId() == null ||
            student.getClassName().equals("") ||
            student.getCitizenId() == null){
            return new Response(false , "Fill all required cells");
        } else {
            studentList.add(student);
        }
        return new Response(true, "Add student successfully!\n" + student);
    }

    @Override
    public Object deleteStudentByStudentId(int studentId) {
        int n = studentList.size();
        if ( n == 0 ) return new Response(false, "There is nothing to delete\nPlease add one more student");
        boolean isHave = false;
        for ( int i = 0 ; i < n ; i++ ){
            Student currStudent = studentList.get(i);
            if (currStudent.getStudentId() == studentId ){
                studentList.remove(currStudent);
                isHave = true;
            }
        }
        return isHave ? new Response(true, "Deleted successfully student with id: "+ studentId)
            : new Response(false, "There is no student with id: "+studentId);
    }

    @Override
    public Object getPrimaryStudents() {
        int n = studentList.size();
        List<Student> res = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getIsPrimary()) res.add(student);
        }
        if (res.size() == 0){
            return new Response(false,"There is no primary students in this list");
        }
        return new Response(true, res.toString());
    }

    @Override
    public Object getStudentsFromFaculty(String faculty) {
        return null;
    }

    @Override
    public Object getStudentsFromClass(String classRoom) {
        return null;
    }

    @Override
    public Object getStudentFromStudentId(int studentId) {
        return null;
    }

    @Override
    public Object getStudentsFromTrainingPointInRange(int start, int end) {
        return null;
    }

    @Override
    public Object updateStudentFaculty(int studentId, String faculty) {
        return null;
    }

    @Override
    public Object updateStudentClass(int studentId, String classRoom) {
        return null;
    }

    @Override
    public Object updateStudentPrimary(int studentId) {
        return null;
    }

    @Override
    public Object updateStudentTrainingPoint(int studentId, int trainingPoint) {
        return null;
    }

    @Override
    public Object updateStudentAddress(int studentId, String address) {
        return null;
    }

    @Override
    public Object updateStudentNumber(int studentId, String number) {
        return null;
    }

    @Override
    public Object updateStudentAccumulateNumber(int studentId, int accumulateNumber) {
        return null;
    }
}
