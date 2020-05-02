package com.san.design;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WellsFargo extends ETVPark {

    public WellsFargo(Garden garden) {
        super(garden);
    }
}
