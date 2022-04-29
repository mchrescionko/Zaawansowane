package plikiSerializacja.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "renault");
        objectMapper.writeValue(new File("target/car.json"), car);

        String carAsString = objectMapper.writeValueAsString(car);

//        System.out.println("String: "+carAsString);
//
//        byte [] carAsBytes = objectMapper.writeValueAsBytes(car);
//        for (byte carAsByte : carAsBytes) {
//            System.out.println(carAsByte);
//        }

        Car car2 = objectMapper.readValue(carAsString, Car.class);
        System.out.println("car2: "+car2);

        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});

        System.out.println("listCar: "+listCar);



    }
}
