package com.example.studentmanagement.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Abstract object class
 */

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

    /**
     * No args constructor for use in serialization
     *
     */
    public Person() {
    }

    /**
     *
     * @param number
     * @param name
     * @param citizenId
     */
    public Person(String name, String number, Long citizenId) {
        super();
        this.name = name;
        this.number = number;
        this.citizenId = citizenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Person.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("number");
        sb.append('=');
        sb.append(((this.number == null)?"<null>":this.number));
        sb.append(',');
        sb.append("citizenId");
        sb.append('=');
        sb.append(((this.citizenId == null)?"<null>":this.citizenId));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}