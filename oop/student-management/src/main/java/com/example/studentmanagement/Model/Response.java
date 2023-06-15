package com.example.studentmanagement.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("info")
    @Expose
    private String info;

    /**
     * No args constructor for use in serialization
     *
     */
    public Response() {
    }

    /**
     *
     * @param status
     * @param info
     */
    public Response(Boolean status, String info) {
        super();
        this.status = status;
        this.info = info;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Response.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("info");
        sb.append('=');
        sb.append(((this.info == null)?"<null>":this.info));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}

