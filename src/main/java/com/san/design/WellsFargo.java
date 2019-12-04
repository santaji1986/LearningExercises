package com.san.design;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class WellsFargo extends ETVPark {
    public WellsFargo() {
    }

    public WellsFargo(Garden garden) {
        super(garden);
    }
}
