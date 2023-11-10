package com.nimbasms.nimbasms.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public final class JsonParser {

    private static final ObjectMapper mapper = new ObjectMapper();

    private JsonParser() {
    }

    public static String convertObjectToJsonString(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserializeJsonString(String json, Class<T> clazz) {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        T response = null;
        try {
            response = mapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}