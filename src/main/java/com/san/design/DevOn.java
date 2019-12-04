package com.san.design;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class DevOn extends ETVPark {

    public DevOn() {
    }

    public DevOn(Garden garden) {
        super(garden);
    }

    public DevOn(Garden garden, Cafeteria cafeteria) {
        super(garden, cafeteria);
    }

}
