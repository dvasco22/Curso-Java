package com.cdsb.serial;

import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDate;

import com.cdsb.files.FileSystem2;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class JacksonCyclist {

    Cyclist cyclist;
    Bicycle[] bikes;
    String pathName = "demos-persis/resources/cyclist.json";
    ObjectMapper mapper = new ObjectMapper();

    public JacksonCyclist() throws JsonMappingException, JsonProcessingException {
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        mapper.registerModule(new JavaTimeModule());
        // This is needed to avoid writing dates as timestamps
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        cyclist = new Cyclist("Pepe", LocalDate.of(2000, 10, 23));
        readBikes();
        for (int i = 0; i < bikes.length; i++) {
            cyclist.addBike(bikes[i]);
        }
        System.out.println(cyclist);
    }

    private void saveCyclist() throws JsonProcessingException {
        System.out.println("Saving cyclist...");
        String cyJSON = mapper.writeValueAsString(cyclist);
        FileSystem2.writeFile(pathName, cyJSON);
    }

    private void saveCyclist2() {
        System.out.println("Saving cyclist (v.2)...");
        StringWriter cyJSON = new StringWriter();
        try {
            mapper.writeValue(cyJSON, cyclist);
            FileSystem2.writeFile(pathName, cyJSON.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void readBikes() throws JsonMappingException, JsonProcessingException {
        String pathName = "demos-persis/resources/bikes.json";
        String jsonString = FileSystem2.readFileToString(pathName);
        bikes = mapper.readValue(jsonString, Bicycle[].class);
    };

    public static void main(String[] args) {
        try {
            JacksonCyclist jCyclist = new JacksonCyclist();

            jCyclist.saveCyclist2();
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}