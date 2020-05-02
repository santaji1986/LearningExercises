package com.san.json;

import com.google.gson.annotations.SerializedName;

public enum Gender {

    @SerializedName("Man")
    M("Man"),

    @SerializedName("Woman")
    F("Woman"),

    @SerializedName("Other")
    O("Other");

    private String value;

    private Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
