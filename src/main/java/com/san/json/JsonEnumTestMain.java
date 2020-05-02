package com.san.json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonEnumTestMain {

    public static void main(String[] args) {

        System.out.println("Processing MyDTO");
        parseSingleObject();

        System.out.println("Processing MyDTO[]");
        parseArray();

        System.out.println("Processing List<MyDTO>");
        parseList();
    }

    private static void parseList() {
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

        System.out.println("Original List of Obj == Deserialized from Json List of obj : " + personDTOs.equals(fromJson));
    }

    private static void parseSingleObject() {
        final PersonDTO personDTO = new PersonDTO("ABC", "u1", Nationality.INDIAN, Gender.M);
        final Gson gson = new Gson();
        String jsonStr = gson.toJson(personDTO);
        System.out.println("Json : " + jsonStr);
        jsonStr = jsonStr.replace("INDIAN", "HINDUSTANI");
        System.out.println("Json : " + jsonStr);

        final PersonDTO fromJson = gson.fromJson(jsonStr, PersonDTO.class);

        System.out.println("Original Obj == Deserialized from Json : " + personDTO.equals(fromJson));
    }

    private static void parseArray() {
        final PersonDTO personDTO1 = new PersonDTO("ABC", "u1", Nationality.INDIAN, Gender.M);
        final PersonDTO personDTO2 = new PersonDTO("DEF", "u2", Nationality.DUTCH, Gender.F);
        final PersonDTO personDTO3 = new PersonDTO("GHI", "u3", Nationality.AMERICAN, Gender.O);
        final PersonDTO[] personDTOs = new PersonDTO[] { personDTO1, personDTO2, personDTO3 };

        final Gson gson = new Gson();
        final String jsonStr = gson.toJson(personDTOs);
        System.out.println("Json : " + jsonStr);

        final PersonDTO[] myDTOs = gson.fromJson(jsonStr, PersonDTO[].class);

        System.out.println("Original Obj[] == Deserialized from Json[]: " + Arrays.deepEquals(personDTOs, myDTOs));
    }

}
