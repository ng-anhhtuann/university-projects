package com.example.studentmanagement.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DoubleReq {
    @SerializedName("studentId")
    @Expose
    private Long studentId;
    @SerializedName("avgPoint")
    @Expose
    private Double avgPoint;
}