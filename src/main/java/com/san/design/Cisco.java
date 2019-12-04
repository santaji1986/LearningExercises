package com.san.design;

import lombok.AllArgsConstructor;

//@Data
//@ToString(callSuper = true)
@AllArgsConstructor
public class Cisco extends ETVPark {
    private String special = "";

    public Cisco() {
        this.special = "Specialized in Networking";
    }

    @Override
    public String toString() {
        return "Cisco(special=" + special + ", " + super.toString() + ")";
    }
}
