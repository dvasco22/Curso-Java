package com.cdsb.serial;

import com.cdsb.files.FileSystem2;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonTools {

    ObjectMapper mapper = new ObjectMapper();

    public JsonTools() {
        // Set visibility for fields to be accessible
        // This allows Jackson to serialize/deserialize private fields
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        mapper.registerModule(new JavaTimeModule());
        // This is needed to avoid writing dates as timestamps
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }


    public <T extends Object> String toJson(T obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T extends Object> void toJsonFile(T obj, String filePath) {
        try {
            String json = mapper.writeValueAsString(obj);
            FileSystem2.writeFile(filePath, json);
            // mapper.writeValue(FileSystem2.getFile(filePath), obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public <T> T fromJsonFile(String filePath, Class<T> clazz) {
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
