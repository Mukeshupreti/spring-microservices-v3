package algorithms.inteview;

import java.util.*;

// input sequence of numbers separated by ;
// output  number of duplicate;lowest depulicate; highest duplicate; non duplicate array of number
public class StringSequence {

    //
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String input= scanner.nextLine();

        String values[]= input.split(";");
        Map<String,Integer> map= new LinkedHashMap<>();

        for(String value:values){
         if(map.containsKey(value)){
             int count=map.get(value);
             count=count+1;
             map.put(value,count);

         }else{
             map.put(value,1);
         }
        }
        System.out.println(map);

        int noOfDuplicate=0;
        int lowestDuplicate=0;
        int heightDuplicate=0;
        String uniqueArray="";
        for(String key:map.keySet()){
            uniqueArray+=key+";";
            if(map.get(key)>1){
                noOfDuplicate++;
                lowestDuplicate=Integer.valueOf(key);//5 2
                if(heightDuplicate<lowestDuplicate){
                    int temp=lowestDuplicate;//5
                    lowestDuplicate=heightDuplicate;//0
                    heightDuplicate=temp;//5

                }
            }
        }
        System.out.println(noOfDuplicate+"|"+lowestDuplicate+";"+heightDuplicate+"|"+uniqueArray);

        }





    }

