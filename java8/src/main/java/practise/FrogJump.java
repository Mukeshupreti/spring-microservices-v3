package practise;


/*4. Frog Jump

Tested: Arithmetic, math logic

A frog jumps from position X to Y in steps of size S.
Find minimum jumps required.

Example:
X = 10, Y = 85, s = 30
Output: 3  (10→40→70→100)*/
public class FrogJump {

    public static void main(String[] args) {

       int steps=  FrogJump.solution(10,85,30);
        System.out.println(steps);
    }

    private static int solution(int x, int y, int s) {
        if (x >= y) return 0;
        int start=x;
        int countstep=0;
        while(start<y){
            start=start+s;
            countstep++;
        }
        return countstep;
    }
  /*  Formula (Y - X) = total distance to cover.
    Divide by D = how many jumps.
            Use ceil() since the last partial jump still counts as one full jump. 2.5 will become 3*/
    private static int solutionOptimal(int x, int y, int s) {
        if (x >= y) return 0;
        return (int) Math.ceil((double)(y - x) / s);

    }
}
