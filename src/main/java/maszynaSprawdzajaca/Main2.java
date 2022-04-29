package maszynaSprawdzajaca;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("test77"));
        System.out.println(System.in.read());
        String answers = String.valueOf(System.in.read());
        System.out.println("answers: " +answers);
        char [] chars = answers.toCharArray();
        List<Integer> integerList = new ArrayList<>();
        for (char aChar : chars) {
            if(aChar==','){

            }else{
                integerList.add(Integer.parseInt(String.valueOf(aChar)));
            }
        }

        System.out.println(integerList);


        PrintWriter printWriter = new PrintWriter("results");
        for (Integer integer : integerList) {
            if(integer==extracted()){
                printWriter.println(1);
            }else{
                printWriter.println(0);
            }
        }
        printWriter.close();

        int result = extracted();


    }

    private static int extracted() {
        int x = 0;
        int result = 1;
        if(x == 0){
            System.out.println("1");
        }else{
            for(int i=1;i<=x;i++){
                result = result*i;
            }
            System.out.println(result);
        }
        return result;
    }
}
