package fansir.me.springweb.common.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import fansir.me.springweb.common.enumeration.PageEnum;

import java.io.IOException;

/**
 * Class Name: PageEnumSerializer Description: TODO
 * 
 *
 */

public class PageEnumSerializer extends JsonSerializer<PageEnum> {

    @Override
    public void serialize(PageEnum value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("code");
        jsonGenerator.writeString(value.getCode());
        jsonGenerator.writeFieldName("text");
        jsonGenerator.writeString(value.getText());
        jsonGenerator.writeFieldName("name");
        jsonGenerator.writeString(value.name());
        jsonGenerator.writeEndObject();
    }
}
