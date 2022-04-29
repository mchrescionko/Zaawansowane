package plikiSerializacja;

import com.fasterxml.jackson.databind.*;

import java.io.File;
import java.io.IOException;

public class Main3 {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        MyObject myObject = objectMapper.readValue(new File("SomeFile.json"), MyObject.class);
        System.out.println(myObject);
        String json = objectMapper.writeValueAsString(myObject);
        System.out.println("json:" + json);

        String [] tab = new String []{"raz", "dwa", "trzy"};

        MyObject myObject1 = new MyObject();
        myObject.sayHello(tab);
        myObject.sayHello("raz", "dwa", "trzy", "cztery");

    }
}



