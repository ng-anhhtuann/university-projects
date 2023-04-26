package com.example.studentmanagement.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Response {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("info")
    @Expose
    private String info;
}

