package algorithms.StringAndArray;

public class RemoveDuplicateElement {

    public static void main(String[] args) {

        char []source= new char[]{'a','b','b','c','a','d','0'};
        System.out.println("before");
        print(source);
        System.out.println();

        removeDuplicatesEff(source);

        System.out.println("after");
        print(source);
    }



    public static void removeDuplicatesEff(char[] str) {
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;
        boolean[] hit = new boolean[256];
        for (int i = 0; i < 256; ++i) {
            hit[i] = false;
        }
        hit[str[0]] = true;
        int tail = 1;
        for (int i = 1; i < len; ++i) {
            if (!hit[str[i]]) {
                str[tail] = str[i];
                ++tail;
                hit[str[i]] = true;
            }
        }
        str[tail] = '@';
    }

    static  void  print(char []a){

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}
