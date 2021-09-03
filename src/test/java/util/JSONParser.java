package util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.io.StringWriter;

public interface JSONParser {


    static String parse(Object objectToParse) {

        JsonMapper mapper = new JsonMapper();
        StringWriter writer = new StringWriter();

        try {
            mapper.writeValue(writer, objectToParse);
            System.out.println(writer);

        } catch (JsonGenerationException | JsonMappingException e) {
            e.getLocalizedMessage();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }


}
