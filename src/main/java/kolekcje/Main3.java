//package kolekcje;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.*;
//
//public class Main3 {
//    public static void main(String[] args) {
//
//    }
//
//
//    public static List<String> odczyt() throws FileNotFoundException {
//        File plik = new File("slowa.txt");
//        Scanner scanner = new Scanner(plik);
//        List<String> lista = new ArrayList<>();
//        String tekst;
//        while (scanner.hasNextLine()) {
//            boolean czyDodany = false;
//            tekst = scanner.nextLine();
//            List<String> nowalista = Arrays.asList(tekst.split(""));
//            List<Character> listacharow = new ArrayList<>();
//            for (String s : nowalista) {
//                char c = s.charAt(0);
//                if (c < 123 && c > 65) {
//                    listacharow.add(c);
//                } else {
//                    listacharow.add(".".charAt(0));
//                }
//            }
//            String text ="";
//            List<String> stringList = new ArrayList<>();
//            for (Character character : listacharow) {
//                text = text + character.toString();
//            }
//            List<String> nowaLista = new ArrayList<>();
//            nowaLista = Arrays.asList(text.split("."));
//
//
//        }
//
//        return nowa;
//
//    }
//}
//}
