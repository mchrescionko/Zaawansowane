package maszynaSprawdzajaca;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int result = 1;
        if(x == 0){
            System.out.println("1");
        }else{
            for(int i=1;i<=x;i++){
                result = result*i;
            }
            System.out.println(result);
        }
    }
}
