package com.project3.tpbooking.utils.time;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateDeSerializer extends JsonDeserializer<Date> {
    public static final String SDF_FORMAT = "yyyy/MM/dd HH:mm:ss";

    public CustomDateDeSerializer() {
    }

    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String dateString = jsonParser.getText();
        if (StringUtils.isEmpty(dateString)) {
            return null;
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            dateFormat.setLenient(false);
            Date date = null;

            try {
                date = dateFormat.parse(dateString);
                return date;
            } catch (ParseException var7) {
                throw new IOException("cant parse dat, format: yyyy/MM/dd HH:mm:ss, received: " + dateString);
            }
        }
    }
}