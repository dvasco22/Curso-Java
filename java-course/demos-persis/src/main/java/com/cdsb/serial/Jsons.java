package com.cdsb.serial;

import com.cdsb.files.FileSystem2;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Jsons {

    private static ObjectMapper mapper = new ObjectMapper();

    private static void setConfig() {
        // Set visibility for fields to be accessible
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        // This allows Jackson to serialize/deserialize private fields
        mapper.registerModule(new JavaTimeModule());
        // This is needed to avoid writing dates as timestamps
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }


    public static <T extends Object> String toJson(T obj) {
        setConfig();
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        setConfig();
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T extends Object> void toJsonFile(T obj, String filePath) {
        setConfig();
        try {
            String json = mapper.writeValueAsString(obj);
            FileSystem2.writeFile(filePath, json);
            // mapper.writeValue(FileSystem2.getFile(filePath), obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static <T> T fromJsonFile(String filePath, Class<T> clazz) {
        setConfig();
        try {
            String json = FileSystem2.readFileToString(filePath);
            return mapper.readValue(json, clazz);
            // return mapper.readValue(FileSystem2.getFile(filePath), clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
