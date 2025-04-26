package practise;

public class Fabonaci {


    public static void main(String[] args) {

        // 0,1,1,2,3,5
        int num1=0;
        int num2=1;
        int result=0;
        System.out.println(num1);
        System.out.println(num2);
        for (int i=1;i<=10;i++){

            result=num1+num2;
            System.out.println(result);
            num1=num2;
            num2=result;

        }

    }
}
