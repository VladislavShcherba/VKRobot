package helper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONHelper {
    public static JSONObject fileToJSONObject(String file) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(file);
        return (JSONObject) parser.parse(reader);
    }
}
