/* https://community.topcoder.com/stat?c=problem_statement&pm=1692 */

import java.util.Arrays;

public class Yahtzee{
	public 	int maxPoints(int[] toss){
		int[] vals = new int[7];
		Arrays.fill(vals, 0);

		int max = 0;
		for(int t : toss){
			vals[t] += t;
			if(vals[t] > max){
				max = vals[t];
			}
		}

		return max;
	}

	public static void main(String[] args){
		Yahtzee yh = new Yahtzee();
		yh.test();
	}

	private void test(){
		int[][] toss = new int[][]{
			{ 2, 2, 3, 5, 4 },
			{ 6, 4, 1, 1, 3 },
			{ 5, 3, 5, 3, 3 }
		};

		int[] want = new int[]{5, 6, 10};

		for(int i=0; i < toss.length; i++){
			int got = maxPoints(toss[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t want: "+want[i]+"\t got: "+got);

			System.out.println(sb.toString());
		}
	}
}