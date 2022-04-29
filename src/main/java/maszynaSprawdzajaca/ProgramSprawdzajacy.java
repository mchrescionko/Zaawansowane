package maszynaSprawdzajaca;

import java.io.*;
import java.util.Scanner;

public class ProgramSprawdzajacy {
    public static void main(String[] args) throws IOException {

        sprawdzenie("poprawneWynikiZadanie1","src/main/java/maszynaSprawdzajaca/wyniki/zadanie1","src/main/java/maszynaSprawdzajaca/oceny/zadanie1");
        sprawdzenie("poprawneWynikiZadanie2","src/main/java/maszynaSprawdzajaca/wyniki/zadanie2","src/main/java/maszynaSprawdzajaca/oceny/zadanie2");
        sprawdzenie("poprawneOdpowiedziZadanie3","src/main/java/maszynaSprawdzajaca/wyniki/zadanie3","src/main/java/maszynaSprawdzajaca/oceny/zadanie3");

    }

    private static void sprawdzenie(String pathPoprawneOdpowiedzi, String pathWyniki, String pathOceny) throws IOException {
        PrintWriter printWriter = new PrintWriter(pathOceny);

        File file2 = new File(pathPoprawneOdpowiedzi);
        Scanner scanner = new Scanner(file2);
        int wynik = scanner.nextInt();



        File folder = new File(pathWyniki);
        File[] fileList = folder.listFiles();
        for(File file: fileList){
            String path = file.getPath();
            Process p = Runtime.getRuntime().exec("java " +path);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String answer = in.readLine();
            System.out.println("answer: "+answer);

            if(Integer.parseInt(answer)==wynik){
                printWriter.println("odpowiedz poprawna");
            }else{
                printWriter.println("odpowiedz niepoprawna");
            }
        }


        printWriter.close();
    }
    private static void sprawdzenieZadania2() throws IOException {
        PrintWriter printWriter = new PrintWriter("wyniki2");

        File folder = new File("src/main/java/maszynaSprawdzajaca/wyniki/zadanie2");
        File[] fileList = folder.listFiles();
        for(File file: fileList){
            String path = file.getPath();
            Process p = Runtime.getRuntime().exec("java " +path);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String answer = in.readLine();
            System.out.println("answer: "+answer);

            if(Integer.parseInt(answer)==6){
                printWriter.println("odpowiedz poprawna");
            }else{
                printWriter.println("odpowiedz niepoprawna");
            }
        }


        printWriter.close();
    }

}

