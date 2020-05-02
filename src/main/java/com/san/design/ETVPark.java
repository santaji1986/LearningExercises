package com.san.design;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ETVPark {
    Garden garden = new Garden("ETV Garden");
    Cafeteria cafeteria = new Cafeteria("ETV cafeteria");

    public ETVPark(Garden garden) {
        this(garden, new Cafeteria("ETV cafeteria"));
    }

    public ETVPark(Cafeteria cafeteria) {
        this(new Garden("ETV Garden"), cafeteria);
    }
}
