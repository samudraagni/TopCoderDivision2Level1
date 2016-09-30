/* https://community.topcoder.com/stat?c=problem_statement&pm=4564 */

import java.util.Arrays;

public class TeamSplit{
	public int difference(int[] strengths){

		Arrays.sort(strengths);

		int fSum = 0;
		int sSum = 0;

		for(int i= strengths.length -1; i >= 0; i-= 2){
			fSum += strengths[i];

			if(i-1 >= 0) sSum += strengths[i-1];
		}

		return (int)(Math.abs(fSum - sSum));
	}

	public static void main(String[] args){
		TeamSplit ts = new TeamSplit();
		ts.test();
	}

	private void test(){
		int[][] strengths = new int[][]{
			{5,7,8,4,2},
			{100},
			{1000,1000},
			{9,8,7,6},
			{1,5,10,1,5,10},
			{824, 581,   9, 776, 149, 493, 531, 558, 995, 637,
 394, 526, 986, 548, 344, 509, 319,  37, 790, 491,
 479,  34, 776, 321, 258, 851, 711, 365, 763, 355,
 386, 877, 596,  96, 151, 166, 558, 109, 874, 959,
 845, 181, 976, 335, 930,  22,  78, 120, 907, 584}
		};

		int[] want = new int[]{4, 100, 0, 2, 0, 478};

		for(int i=0; i < strengths.length; i++){
			int got = difference(strengths[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}