package fansir.me.springweb.common.security.xss;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.owasp.encoder.Encode;

import java.io.IOException;

/**
 * Class Name: XssSantizeJsonSerializer
 * Description: Sanitize String type fields in object for json serialization.   
 *
 */
public class XssSantizeJsonSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        if (value != null) {
            String encoded = Encode.forHtml(value);
            jsonGenerator.writeString(encoded);
        }
    }
}
