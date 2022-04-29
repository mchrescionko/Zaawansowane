package maszynaSprawdzajaca;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int result = 1;
        if(x == 0){
            System.out.println("0");
        }else{
            for(int i=1;i<=x;i++){
                result = result*i+1;
            }
            System.out.println(result);
        }
    }
}
