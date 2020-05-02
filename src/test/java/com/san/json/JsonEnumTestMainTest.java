package com.san.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

class JsonEnumTestMainTest {

    @Test
    void testSingleObjTransformation() {
        final PersonDTO personDTO1 = new PersonDTO("ABC", "u1", Nationality.INDIAN, Gender.M);
        final Gson gson = new Gson();
        String jsonStr = gson.toJson(personDTO1);
        System.out.println("Json : " + jsonStr);
        jsonStr = jsonStr.replace("INDIAN", "HINDUSTANI");
        System.out.println("Json : " + jsonStr);
        final PersonDTO fromJson = gson.fromJson(jsonStr, PersonDTO.class);
        assertEquals(personDTO1, fromJson);
    }

    @Test
    void testArrayObjTransformation() {
        final PersonDTO personDTO1 = new PersonDTO("ABC", "u1", Nationality.INDIAN, Gender.M);
        final PersonDTO personDTO2 = new PersonDTO("DEF", "u2", Nationality.DUTCH, Gender.F);
        final PersonDTO personDTO3 = new PersonDTO("GHI", "u3", Nationality.AMERICAN, Gender.O);
        final PersonDTO[] personDTOs = new PersonDTO[] { personDTO1, personDTO2, personDTO3 };

        final Gson gson = new Gson();
        final String jsonStr = gson.toJson(personDTOs);
        System.out.println("Json : " + jsonStr);

        final PersonDTO[] myDTOs = gson.fromJson(jsonStr, PersonDTO[].class);

        assertTrue(Arrays.deepEquals(personDTOs, myDTOs));
    }

    @Test
    void testListObjTransformation() {
        final PersonDTO personDTO1 = new PersonDTO("ABC", "u1", Nationality.INDIAN, Gender.M);
        final PersonDTO personDTO2 = new PersonDTO("DEF", "u2", Nationality.DUTCH, Gender.F);
        final PersonDTO personDTO3 = new PersonDTO("GHI", "u3", Nationality.AMERICAN, Gender.O);
        final List<PersonDTO> personDTOs = new ArrayList<>(Arrays.asList(personDTO1, personDTO2, personDTO3));

        final Gson gson = new Gson();
        final String jsonStr = gson.toJson(personDTOs);
        System.out.println("Json : " + jsonStr);

        final Type type = new TypeToken<List<PersonDTO>>() {
        }.getType();
        final List<PersonDTO> fromJson = gson.fromJson(jsonStr, type);

        assertEquals(personDTOs, fromJson);
    }

}
