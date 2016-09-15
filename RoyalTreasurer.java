/* https://community.topcoder.com/stat?c=problem_statement&pm=10007 */

import java.util.Arrays;

public class RoyalTreasurer{
	public int minimalArrangement(int[] A, int[] B){
		Arrays.sort(A);

		for(int i=0; i < B.length; i++){
			B[i] = -B[i];
		}
		Arrays.sort(B);
		for(int i=0; i < B.length; i++){
			B[i] = -B[i];
		}

		int val = 0;
		for(int i=0; i < A.length; i++){
			val += A[i] * B[i];
		}

		return val;
	}

	public static void main(String[] args) {
		RoyalTreasurer rt = new RoyalTreasurer();
		rt.test();
	}

	private void test(){
		int[][] A = new int[][]{
			{1,1,3},
			{1,1,1,6,0},
			{5,15,100,31,39,0,0,3,26}
		};

		int[][] B = new int[][]{
			{10,30,20},
			{2,7,8,3,1},
			{11,12,13,2,3,4,5,9,1}
		};

		int[] want = new int[]{80, 18, 528};

		for(int i=0; i < A.length; i++){
			int got = minimalArrangement(A[i], B[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}