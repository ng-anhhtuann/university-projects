package com.example.studentmanagement.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Encapsulation with datafields and getters/setters
 * Polymorphism with initialize objects by constructor
 * Inheritance from Person
 */
public class Student extends Person {
    @SerializedName("studentId")
    @Expose
    private Long studentId;
    @SerializedName("avgPoint")
    @Expose
    private Double avgPoint;
    @SerializedName("className")
    @Expose
    private String className;
    @SerializedName("born")
    @Expose
    private String born;
    @SerializedName("address")
    @Expose
    private String address;

    /**
     * No args constructor for use in serialization
     *
     */
    public Student() {
    }

    /**
     *
     * @param studentId
     * @param number
     * @param address
     * @param born
     * @param name
     * @param className
     * @param citizenId
     */
    public Student(Long studentId, String name, String className, Long citizenId, Double avgPoint, String number, String born, String address) {
        super(name, number, citizenId);
        this.studentId = studentId;
        this.className = className;
        this.avgPoint = avgPoint;
        this.born = born;
        this.address = address;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Double getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(Double avgPoint) {
        this.avgPoint = avgPoint;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MSHS");
        sb.append(':');
        sb.append(((this.studentId == null)?"<null>":this.studentId));
        sb.append(',');
        sb.append("Ho Ten");
        sb.append(':');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("Diem trung binh");
        sb.append(':');
        sb.append(((this.avgPoint == null)?"<null>":this.avgPoint));
        sb.append(',');
        sb.append("Sdt");
        sb.append(':');
        sb.append(((this.number == null)?"<null>":this.number));
        sb.append(',');
        sb.append("CCCD");
        sb.append(':');
        sb.append(((this.citizenId == null)?"<null>":this.citizenId));
        sb.append(',');
        sb.append("Ten lop");
        sb.append(':');
        sb.append(((this.className == null)?"<null>":this.className));
        sb.append(',');
        sb.append("Ngay sinh");
        sb.append(':');
        sb.append(((this.born == null)?"<null>":this.born));
        sb.append(',');
        sb.append("Dia chi");
        sb.append(':');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}