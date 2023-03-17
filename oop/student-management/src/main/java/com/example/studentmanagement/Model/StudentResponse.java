package com.example.studentmanagement.Model;

import com.example.studentmanagement.Utils.Utilities;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("student")
    @Expose
    private Student student;

    /**
     * No args constructor for use in serialization
     *
     */
    public StudentResponse getStudentResponseByType(String type) {
        switch (type) {
            case Utilities.DEFAULT: {
                return new StudentResponse(false, new Student((long) -1,"","","",false,-1,-1, (long) -1,"","",""));
            }
            default: {
                return new StudentResponse();
            }
        }
    }

    public StudentResponse() {
    }

    /**
     *
     * @param student
     * @param status
     */
    public StudentResponse(Boolean status, Student student) {
        super();
        this.status = status;
        this.student = student;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StudentResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("student");
        sb.append('=');
        sb.append(((this.student == null)?"<null>":this.student));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}