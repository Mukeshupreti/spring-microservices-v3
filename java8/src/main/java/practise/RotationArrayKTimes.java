package practise;
/*✅ Task

You are given an array A of N integers and an integer K.

Rotate the array K times to the right.

Return the rotated array.

Rotation example:

A = [3, 8, 9, 7, 6], K = 3


After 1 rotation → [6, 3, 8, 9, 7]
After 2 rotations → [7, 6, 3, 8, 9]
After 3 rotations → [9, 7, 6, 3, 8]

Output:

        [9, 7, 6, 3, 8]*/
public class RotationArrayKTimes {

    public static void main(String[] args) {
        int input[]={3, 8, 9, 7, 6};
        int roated[]= new int[input.length];
        int K=3;
        for(int i=0;i<input.length;i++){
            int newPosition=(i+K)% input.length;
            roated[newPosition]=input[i];
        }
        for(int i: roated){
            System.out.print(i+",");
        }

    }

}
