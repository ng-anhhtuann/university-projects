package com.example.studentmanagement.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

/**
 * Abstract object class
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Person {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("number")
    @Expose
    public String number;
    @SerializedName("citizenId")
    @Expose
    public Long citizenId;
}