package practise;
/*A positive integer N is given. The goal is to find the highest power of 2 that divides N. In other words, we have to find the maximum K for which N modulo 2^K is 0. For example, given integer N = 24 the answer is 3, because 2^3 = 8 is the highest power of 2 that divides N. Write a function: class Solution { public int solution(int N); } that, given a positive integer N, returns the highest power of 2 that divides N. For example, given integer N = 24, the function should return 3, as explained above. Assume that: N is an integer within the range [1..1,000,000,000]. In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment. Copyright 2009–2025 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.*/
public class MaxPowerof2 {
    public static void main(String[] args) {
     MaxPowerof2.solution(24);
    }

  /* find number of 2 in the number it will give you solution
            24=2*2*2*3*/
    public static int solution(int N) {
        int power = 0;

        while (N % 2 == 0) {
            N = N / 2;
            power++;
            System.out.println(N);
        }

        return power;
    }

}
