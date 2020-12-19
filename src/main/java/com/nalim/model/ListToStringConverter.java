package com.nalim.model;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.List;

public class ListToStringConverter implements AttributeConverter<List<String>, String> {
    private static final String SPLIT_CHA=",";

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return String.join(SPLIT_CHA,attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return Arrays.asList(dbData.split(SPLIT_CHA));
    }
}
