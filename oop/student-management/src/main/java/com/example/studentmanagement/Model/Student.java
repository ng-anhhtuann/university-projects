package com.example.studentmanagement.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Encapsulation with datafields and getters/setters
 * Polymorphism with initialize objects by constructor
 */
public class Student {

    @SerializedName("studentId")
    @Expose
    private Integer studentId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("faculty")
    @Expose
    private String faculty;
    @SerializedName("className")
    @Expose
    private String className;
    @SerializedName("isPrimary")
    @Expose
    private Boolean isPrimary;
    @SerializedName("trainingPoint")
    @Expose
    private Integer trainingPoint;
    @SerializedName("accumulateNumber")
    @Expose
    private Integer accumulateNumber;
    @SerializedName("citizenId")
    @Expose
    private Long citizenId;
    @SerializedName("number")
    @Expose
    private String number;
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
     * @param isPrimary
     * @param trainingPoint
     * @param born
     * @param name
     * @param className
     * @param citizenId
     * @param faculty
     * @param accumulateNumber
     */
    public Student(Integer studentId, String name, String faculty, String className, Boolean isPrimary, Integer trainingPoint, Integer accumulateNumber, Long citizenId, String number, String born, String address) {
        super();
        this.studentId = studentId;
        this.name = name;
        this.faculty = faculty;
        this.className = className;
        this.isPrimary = isPrimary;
        this.trainingPoint = trainingPoint;
        this.accumulateNumber = accumulateNumber;
        this.citizenId = citizenId;
        this.number = number;
        this.born = born;
        this.address = address;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public Integer getTrainingPoint() {
        return trainingPoint;
    }

    public void setTrainingPoint(Integer trainingPoint) {
        this.trainingPoint = trainingPoint;
    }

    public Integer getAccumulateNumber() {
        return accumulateNumber;
    }

    public void setAccumulateNumber(Integer accumulateNumber) {
        this.accumulateNumber = accumulateNumber;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        sb.append(Student.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("MSSV");
        sb.append(':');
        sb.append(((this.studentId == null)?"<null>":this.studentId));
        sb.append(',');
        sb.append("Ho Ten");
        sb.append(':');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("Nganh");
        sb.append(':');
        sb.append(((this.faculty == null)?"<null>":this.faculty));
        sb.append(',');
        sb.append("Ten lop");
        sb.append(':');
        sb.append(((this.className == null)?"<null>":this.className));
        sb.append(',');
        sb.append("Dao tao");
        sb.append(':');
        sb.append(((this.isPrimary)?"Chinh quy":"Chat luong cao"));
        sb.append(',');
        sb.append("Diem ren luyen");
        sb.append(':');
        sb.append(((this.trainingPoint == null)?"<null>":this.trainingPoint));
        sb.append(',');
        sb.append("Tin chi tich luy");
        sb.append(':');
        sb.append(((this.accumulateNumber == null)?"<null>":this.accumulateNumber));
        sb.append(',');
        sb.append("CCCD");
        sb.append(':');
        sb.append(((this.citizenId == null)?"<null>":this.citizenId));
        sb.append(',');
        sb.append("So dien thoai");
        sb.append(':');
        sb.append(((this.number == null)?"<null>":this.number));
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