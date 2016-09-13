/* https://community.topcoder.com/stat?c=problem_statement&pm=11741 */
import java.io.*;

public class PairingPawns{
	public int savedPawnCount(int[] start){
		for(int i=start.length-1; i > 0; i--){
			
			if(start[i] % 2 != 0) start[i] = start[i]-1;

			int p = start[i]/2;
			start[i-1] =  start[i-1] + p;
		}
		return start[0];
	}
//}

	public static void main(String[] args) {
		PairingPawns pp = new PairingPawns();
		pp.test();
	}

	private void test(){
		int[][] start = new int[][]{
			{0,2},
			{10,3},
			{0,0,0,8},
			{0,1,1,2},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,123456},
			{1000,2000,3000,4000,5000,6000,7000,8000}
		};

		int[] want = new int[]{1, 11, 1, 1, 0, 3921};
		for(int i=0; i < start.length; i++){
			int got = savedPawnCount(start[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}