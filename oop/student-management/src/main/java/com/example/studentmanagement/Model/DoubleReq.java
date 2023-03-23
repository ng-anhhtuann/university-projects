package com.example.studentmanagement.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoubleReq {

    @SerializedName("studentId")
    @Expose
    private Long studentId;
    @SerializedName("avgPoint")
    @Expose
    private Double avgPoint;

    /**
     * No args constructor for use in serialization
     *
     */
    public DoubleReq() {
    }

    /**
     *
     * @param studentId
     * @param avgPoint
     */
    public DoubleReq(Long studentId, Double avgPoint) {
        super();
        this.studentId = studentId;
        this.avgPoint = avgPoint;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Double getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(Double avgPoint) {
        this.avgPoint = avgPoint;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DoubleReq.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("studentId");
        sb.append('=');
        sb.append(((this.studentId == null)?"<null>":this.studentId));
        sb.append(',');
        sb.append("avgPoint");
        sb.append('=');
        sb.append(((this.avgPoint == null)?"<null>":this.avgPoint));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}