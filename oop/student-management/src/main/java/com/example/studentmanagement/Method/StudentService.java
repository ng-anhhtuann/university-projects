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
        for ( int i = 0 ; i < n ; i++ ){
            Student currStudent = studentList.get(i);
            if (currStudent.getStudentId() == studentId ){
                studentList.remove(currStudent);
                return new Response(true, "Deleted successfully student with id: "+ studentId);
            }
        }
        return new Response(false, "There is no student with id: "+studentId);
    }

    @Override
    public Object getPrimaryStudents() {
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
        List<Student> res = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getFaculty().equals(faculty)) res.add(student);
        }
        if (res.size() == 0){
            return new Response(false,"There is no students in " + faculty);
        }
        return new Response(true, res.toString());
    }

    @Override
    public Object getStudentsFromClass(String classRoom) {
        List<Student> res = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getClassName().equals(classRoom)) res.add(student);
        }
        if (res.size() == 0){
            return new Response(false,"There is no students in "+classRoom);
        }
        return new Response(true, res.toString());
    }

    @Override
    public Object getStudentFromStudentId(int studentId) {
        for (Student student : studentList) {
            if (student.getStudentId()==studentId) return new Response(true, student.toString());
        }
        return new Response(false, "Student with id " + studentId + " not found!");
    }

    @Override
    public Object getStudentsFromTrainingPointInRange(int start, int end) {
        List<Student> res = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getTrainingPoint() >= start || student.getTrainingPoint() <= end) res.add(student);
        }
        if (res.size() == 0){
            return new Response(false,"There is no students in this range of training point");
        }
        return new Response(true, res.toString());
    }

    @Override
    public Object updateStudentFaculty(int studentId, String faculty) {
        int n = studentList.size();
        if ( n == 0 ) return new Response(false, "Please add one more student");
        for (Student currStudent : studentList) {
            if (currStudent.getStudentId() == studentId) {
                currStudent.setFaculty(faculty);
                return new Response(true, "Update faculty for " + studentId + " successfully");
            }
        }
        return new Response(false, "No student with id "+ studentId+ " in list");
    }


}
