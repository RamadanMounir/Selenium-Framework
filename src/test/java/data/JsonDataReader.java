package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {
    public String firstname , lastname , email , password,newPassword;
    public void JsonReader() throws IOException, ParseException
    {
        String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.json";

        File srcFile = new File(filePath) ;
        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray)parser.parse(new FileReader(srcFile));

        for(Object jsonObj : jArray)
        {
            JSONObject person = (JSONObject) jsonObj;
            firstname = (String) person.get("firstName");
            System.out.println("firstname =  "+firstname);
            lastname = (String) person.get("lastName");
            System.out.println("lastname =   "+lastname);
            email = (String) person.get("email");
            System.out.println("email    ="+email);
            password = (String) person.get("password");
            System.out.println("password = "+password);
            newPassword = (String) person.get("newPassword");
            System.out.println("newPassword = "+newPassword);
        }
    }

}