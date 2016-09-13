/* https://community.topcoder.com/stat?c=problem_statement&pm=6677 */
import java.io.*;

public class BiggestRectangleEasy{
	public int findArea(int N){

		if(N % 2 != 0) N = N-1;

		int l = N/4;
		int b = l;

		if(N % 4 != 0) b++;

		return l * b;
	}

	public static void main(String[] args) {
		BiggestRectangleEasy bre = new BiggestRectangleEasy();
		bre.test();
	}

	private void test(){
		int[] N = new int[]{11, 5, 64, 753, 7254};
		int[] want = new int[]{6, 1, 256, 35344, 3288782};

		for(int i=0; i < N.length; i++){
			int got = findArea(N[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\t want: "+want[i] + "\t got: "+got);

			System.out.println(sb.toString());
		}
	}
}