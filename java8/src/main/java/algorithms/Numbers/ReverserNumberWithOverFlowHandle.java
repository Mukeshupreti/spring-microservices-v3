package algorithms.Numbers;
import java.util.Scanner;
public class ReverserNumberWithOverFlowHandle {

    public static void main(String args[]){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the number");
        int value= scanner.nextInt();
        System.out.println(value);
        reverserNumber(value);
    }

    private static void reverserNumber(int value) {
        int reverseNumber=0;
        while(value>0){
            int lastDigit=value%10;
            reverseNumber=reverseNumber*10+lastDigit;
            value=value/10;
        }
        System.out.println("reversedNubmer :"+reverseNumber);
    }
}
