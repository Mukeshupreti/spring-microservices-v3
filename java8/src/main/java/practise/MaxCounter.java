package practise;
/*You are given:

N counters (all start at 0).

An array A of operations.

Each element in A means:

If 1 ≤ A[i] ≤ N → increase counter A[i] by 1

If A[i] = N + 1 → set all counters to the maximum value of any counter


Example
N = 5
A = [3, 4, 4, 6, 1, 4, 4]


Step-by-step explanation:

Step	Operation	Action	Result counters
1	3	increase counter 3	[0, 0, 1, 0, 0]
2	4	increase counter 4	[0, 0, 1, 1, 0]
3	4	increase counter 4	[0, 0, 1, 2, 0]
4	6 (=N+1)	set all to max (which is 2)	[2, 2, 2, 2, 2]
5	1	increase counter 1	[3, 2, 2, 2, 2]
6	4	increase counter 4	[3, 2, 2, 3, 2]
7	4	increase counter 4	[3, 2, 2, 4, 2]

Return the final values of all counters.*/
public class MaxCounter {

    public static void main(String[] args) {
        int input[]=new int[]{3, 4, 4, 6, 1, 4, 4};
        MaxCounter.solution(5,input);
    }

   /* If 1 ≤ A[i] ≤ N → increase counter A[i] by 1

    If A[i] = N + 1 → set all counters to the maximum value of any counter*/

    private static void solution(int counter, int[] input) {
        int output[]= new int[counter];

        fillArray(output, 0);
        int maxValue=0;
        for(int i=0;i<input.length;i++){
            if(input[i]<counter){
                output[input[i]-1]++;
                maxValue=Math.max(maxValue,output[input[i]-1]);

            }else if(input[i]==counter+1){
                fillArray(output,maxValue);
            }
  }
        print(output);


    }

    private static void print(int[] output) {
        for(int i = 0; i< output.length; i++){
            System.out.print(output[i]+",");
        }
    }

    private static void fillArray(int[] output, int j) {
        for(int i = 0; i< output.length; i++){
            output[i]= j;
        }
    }

}
