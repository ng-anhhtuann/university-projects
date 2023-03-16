package com.example.studentmanagement.Repository;

import com.example.studentmanagement.Model.Req;
import com.example.studentmanagement.Model.Response;
import com.example.studentmanagement.Model.Student;
import com.example.studentmanagement.Model.StudentResponse;
import com.example.studentmanagement.Utils.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentRepository implements IStudent{

    private static StudentRepository studentRepository = new StudentRepository();

    private static List<Student> studentList = new ArrayList<>();

    /**
     * Singleton design pattern
     * @return always instance of StudentRepository
     */
    public static StudentRepository getStudentRepository(){
        if (studentRepository == null){
            studentRepository = new StudentRepository();
            studentList = new ArrayList<>();
        }
        return studentRepository;
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
            int id = student.getStudentId();
            Long citizenID = student.getCitizenId();
            for ( Student i : studentList){
                if (i.getStudentId() == id || i.getCitizenId().equals(citizenID)){
                    return new Response(false, "Duplicate student in id or citizenId");
                }
            }
            studentList.add(student);
        }
        return new Response(true, "Add successfully");
    }

    @Override
    public Object deleteStudentByStudentId(Map<String, Integer> req) {
        int n = studentList.size();
        if ( n == 0 ) return new Response(false, "There is nothing to delete");
        int studentId = req.get("studentId");
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
    public Object getAllStudents() {
        return studentList;
    }

    @Override
    public Object getPrimaryStudents() {
        List<Student> res = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getIsPrimary()) res.add(student);
        }
        return res;
    }

    @Override
    public Object getStudentsFromFaculty(String faculty) {
        List<Student> res = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getFaculty().equals(faculty)) res.add(student);
        }
        return res;
    }

    @Override
    public Object getStudentsFromClass(String classRoom) {
        List<Student> res = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getClassName().equals(classRoom)) res.add(student);
        }
        return res;
    }

    @Override
    public Object getStudentFromStudentId(Map<String, Integer> req) {
        int studentId = Integer.parseInt(String.valueOf(req.get("studentId")));
        for (Student student : studentList) {
            if (student.getStudentId() == studentId) return new StudentResponse(true, student);
        }
        return new StudentResponse().getStudentResponseByType(Utilities.DEFAULT);
    }

    @Override
    public Object getStudentsLowTrainingPoint() {
        List<Student> res = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getTrainingPoint() >= 0 || student.getTrainingPoint() <= 50) res.add(student);
        }
        return res;
    }

    @Override
    public Object updateStudentFaculty(Req req) {
        int n = studentList.size();
        if ( n == 0 ) return new Response(false, "Please add one more student");
        int studentId = req.getStudentId();
        for (Student currStudent : studentList) {
            if (currStudent.getStudentId() == studentId) {
                currStudent.setFaculty(req.getNewValue());
                return new Response(true, "Update faculty for " + studentId + " successfully");
            }
        }
        return new Response(false, "No student with id "+ studentId+ " in list");
    }

    @Override
    public Object updateStudentClass(Req req) {
        int n = studentList.size();
        if ( n == 0 ) return new Response(false, "Please add one more student");
        int studentId = req.getStudentId();
        for (Student currStudent : studentList) {
            if (currStudent.getStudentId() == studentId) {
                currStudent.setClassName(req.getNewValue());
                return new Response(true, "Update classroom for " + studentId + " successfully");
            }
        }
        return new Response(false, "No student with id "+ studentId+ " in list");
    }

    @Override
    public Object updateStudentPrimary(Map<String, Integer> req) {
        int n = studentList.size();
        if ( n == 0 ) return new Response(false, "Please add one more student");
        int studentId = req.get("studentId");
        for (Student currStudent : studentList) {
            if (currStudent.getStudentId() == studentId) {
                currStudent.setIsPrimary(true);
                return new Response(true, "Update primary program for " + studentId + " successfully");
            }
        }
        return new Response(false, "No student with id "+ studentId+ " in list");
    }

    @Override
    public Object updateStudentTrainingPoint(Map<String, Integer> req) {
        int n = studentList.size();
        if ( n == 0 ) return new Response(false, "Please add one more student");
        int studentId = req.get("studentId");
        int trainingPoint = req.get("trainingPoint");
        for (Student currStudent : studentList) {
            if (currStudent.getStudentId() == studentId) {
                currStudent.setTrainingPoint(trainingPoint);
                return new Response(true, "Update training point for " + studentId + " successfully");
            }
        }
        return new Response(false, "No student with id "+ studentId+ " in list");
    }

    @Override
    public Object updateStudentAddress(Req req) {
        int n = studentList.size();
        if ( n == 0 ) return new Response(false, "Please add one more student");
        int studentId = req.getStudentId();
        for (Student currStudent : studentList) {
            if (currStudent.getStudentId() == studentId) {
                currStudent.setAddress(req.getNewValue());
                return new Response(true, "Update address for " + studentId + " successfully");
            }
        }
        return new Response(false, "No student with id "+ studentId+ " in list");
    }

    @Override
    public Object updateStudentNumber(Req req) {
        int n = studentList.size();
        if ( n == 0 ) return new Response(false, "Please add one more student");
        int studentId = req.getStudentId();
        for (Student currStudent : studentList) {
            if (currStudent.getStudentId() == studentId) {
                currStudent.setNumber(req.getNewValue());
                return new Response(true, "Update number for " + studentId + " successfully");
            }
        }
        return new Response(false, "No student with id "+ studentId+ " in list");
    }

    @Override
    public Object updateStudentAccumulateNumber(Map<String, Integer> req) {
        int n = studentList.size();
        if ( n == 0 ) return new Response(false, "Please add one more student");
        int studentId = req.get("studentId");
        int accumulateNumber = req.get("accumulateNumber");
        for (Student currStudent : studentList) {
            if (currStudent.getStudentId() == studentId) {
                currStudent.setAccumulateNumber(accumulateNumber);
                return new Response(true, "Update accumulate number for " + studentId + " successfully");
            }
        }
        return new Response(false, "No student with id "+ studentId+ " in list");
    }
}
