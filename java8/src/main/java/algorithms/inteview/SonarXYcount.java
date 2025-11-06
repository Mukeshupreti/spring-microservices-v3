package algorithms.inteview;

public class SonarXYcount {


    public static void main(String[] args) {
        String input="ayxbx";
        int count= proccessInput(input);
        System.out.println(count);
    }

    private static int proccessInput(String input) {
        int n=input.length(),count=0;
        String right="",left="";

        for(int i=0;i<n-1;i++){
        left=input.substring(0,i+1);
        right=input.substring(i+1,n);
        System.out.println("input: "+input +" left: "+left +" right: "+right);
        if(calculateXY(left)){
           count++;
        }else if(calculateXY(right)) {
            count++;
        }

        }
        return  count;

    }

    private static boolean calculateXY(String left) {
        int x=0,y=0;
        for(char c :left.toCharArray()){
            if(c=='x'){
                x++;
            }
            if(c=='y'){
                y++;
            }

        }
        if(x==y){
            System.out.println("found  :" +left);
            return true;
        }else{
            return false;
        }

    }


}
