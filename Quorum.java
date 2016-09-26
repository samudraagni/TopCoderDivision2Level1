/* https://community.topcoder.com/stat?c=problem_statement&pm=14219 */

import java.util.Arrays;

public class Quorum{
	public 	int count(int[] arr, int k){
		Arrays.sort(arr);
		int numpeople = 0;

		for(int i=0; i < k; i++){
			numpeople += arr[i];
		}

		return numpeople;
	}
	
	public static void main(String[] args) {
		Quorum q = new Quorum();
		q.test();
	}

	private void test(){
		int[][] arr = new int[][]{
			{5,2,3},
			{1,1,1,1,1},
			{50,2,9,49,38},
			{20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1}
		};

		int[] k = new int[]{1, 5, 3, 14};
		int[] want = new int[]{2, 5, 49, 105};

		for(int i=0; i < arr.length; i++){
			int got = count(arr[i], k[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}