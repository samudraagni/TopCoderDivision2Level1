/* https://community.topcoder.com/stat?c=problem_statement&pm=4561 */

import java.io.*;

public class Straights{
	public int howMany(int[] hand, int k){
		int numways = 0;

		for(int i=0; i < hand.length - k + 1; i++){
			int mult = 1;
			for(int j=i; j < i+k; j++){
				mult *= hand[j];
			}	
			numways += mult;
		}

		return numways;
	}

	public static void main(String[] args) {
		Straights st =  new Straights();
		st.test();
	}

	private void test(){
		int[][] hand = new int[][]{
			{0,3,1,2,0,0,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,1,1,1,1,1,1},
			{4,4,4,4,4,4,4,4,4,4,4,4,4},
			{4,0,4,0,4,0,4,0,4,0,4,0,4},
			{1,2,3,4,1,2,3,4,1,2,3,4,1}
		};

		int[] k = new int[]{2, 5, 13, 2, 1};

		int[] want = new int[]{5, 9, 67108864, 0, 31};
		for(int i=0; i < hand.length; i++){
			int got = howMany(hand[i], k[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+" \t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}