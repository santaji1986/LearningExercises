package com.san.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonDTO {
    private String name;
    private String url;
    private Nationality nationality;
    private Gender gender;

}
