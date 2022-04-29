package maszynaSprawdzajaca;

import pracaZPlikami.ZamianaPlikow;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("answers"));
        Scanner scanner = new Scanner(System.in);

        File folder = new File("src/main/java/maszynaSprawdzajaca/wyniki");
        File[] fileList = folder.listFiles();
        for (File file : fileList) {
            String path = file.getPath();
            Process p = Runtime.getRuntime().exec("java " +path);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String answer = in.readLine();


//            BufferedReader out = new BufferedReader(new OutputStreamWriter(p.getOutputStream()));
//            String answer2 = out.readLine();
//            System.out.println("output stream: "+answer2);
            if (Integer.parseInt(answer) == silnia()) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

//        Process p = Runtime.getRuntime().exec("java src/main/java/maszynaSprawdzajaca/Test.java");




    }

    public static int silnia() throws FileNotFoundException {
        System.setIn(new FileInputStream("answers"));
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int result = 1;
        for (int i = 1; i <= x; i++) {
            result = result * i;

        }
        return result;
    }


}

//na konsoli dostajesz wprowadzone liczby x spacja y wypisz wynik NWD