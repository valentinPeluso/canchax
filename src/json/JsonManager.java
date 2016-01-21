package json;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonManager {
	final private static JsonManager instance = new JsonManager();

	static public JsonManager instance() {
		return JsonManager.instance;
	}

    static public String toJsonString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(object);
        } catch (JsonGenerationException ex) {
            ex.printStackTrace();
        } catch (JsonMappingException ex) {
            ex.printStackTrace();
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }
    
    static public JsonNode toJsonTree(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = null;
        json = mapper.valueToTree(object);
        
        return json;
    }

    static public Object toObject(String json, Class className) {
        ObjectMapper mapper = new ObjectMapper();
        Object result = null;
        try {
            result = mapper.readValue(json, className);
        } catch (IOException ex) {
            Logger.getLogger(JsonManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
