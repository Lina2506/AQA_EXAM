package org.base.helpers.datadeserializer;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataDeserializer extends JsonDeserializer<LocalDateTime> {

@Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");
    LocalDateTime parsed = LocalDateTime.parse(jsonParser.getText(), formatter);
    return parsed.withSecond(0).withNano(0);

}
}
