package com.san.design;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ETVPark {
    Garden garden;
    Cafeteria cafeteria;

    public ETVPark() {
        garden = new Garden("ETV Garden");
        cafeteria = new Cafeteria("ETV cafeteria");
    }

    public ETVPark(Garden garden) {
        this(garden, new Cafeteria("ETV cafeteria"));
    }

    public ETVPark(Cafeteria cafeteria) {
        this(new Garden("ETV Garden"), cafeteria);
    }
}
