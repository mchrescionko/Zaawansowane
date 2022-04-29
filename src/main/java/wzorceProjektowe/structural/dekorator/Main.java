package wzorceProjektowe.structural.dekorator;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        generateMap();
    }

    private static void generateMap() throws IOException {

        Terrain terrain2 = new Plain();
        Terrain terrain3 = new Hill();
        Terrain terrain4 = new Swamp(new Hill());
        Terrain terrain5 = new Forest(new Swamp(new Hill()));



        System.out.println(" fuel cost " + terrain4.fuelCost());
        System.out.println("2 fuel cost " + terrain5.fuelCost());


        FileInputStream fis = new FileInputStream("filename.txt");
        ObjectInputStream oos =  new ObjectInputStream(new FileInputStream("filename.txt"));


    }
}
