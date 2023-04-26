package com.example.studentmanagement.Model;

import com.example.studentmanagement.Utils.Utilities;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
                return new StudentResponse(false,
                    new Student((long) -1,"","",(long) -1, (double) -1, "", "", ""));
            }
            default: {
                return new StudentResponse();
            }
        }
    }
}

