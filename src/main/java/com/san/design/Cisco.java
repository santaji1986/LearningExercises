package com.san.design;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cisco extends ETVPark {
    private String special = "Specialized in Networking";

    @Override
    public String toString() {
        return "Cisco(special=" + special + ", " + super.toString() + ")";
    }
}
