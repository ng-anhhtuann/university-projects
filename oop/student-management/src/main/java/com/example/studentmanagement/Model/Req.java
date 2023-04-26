package com.example.studentmanagement.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Req {
    @SerializedName("studentId")
    @Expose
    private Integer studentId;
    @SerializedName("newValue")
    @Expose
    private String newValue;
}