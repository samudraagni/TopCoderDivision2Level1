/* https://community.topcoder.com/stat?c=problem_statement&pm=11358 */

import java.io.*;
import java.util.*;


public class TheProgrammingContestDivTwo{
	public int[] find(int T, int[] requiredTime){
		Arrays.sort(requiredTime);

		int numSolved = 0;
		int cumulativeTime = 0;
		int sum = 0;

		for(int i=0; i < requiredTime.length; i++){
			sum += requiredTime[i];
			if(sum <= T){
				for(int j=0; j <= i; j++){
					cumulativeTime += requiredTime[j];
				}
				numSolved++;
			}
		}

		return new int[]{numSolved, cumulativeTime};
	}

	public static void main(String[] args){
		TheProgrammingContestDivTwo tpcdt = new TheProgrammingContestDivTwo();
		tpcdt.test();
	}

	private void test(){

		int[] T = new int[]{74, 74, 47, 47, 58, 100000};
		int[][] requiredTime = new int[][]{
			{47},
			{4747},
			{8, 5},
			{12, 3, 21, 6, 4, 13},
			{4, 5, 82, 3, 4, 65, 7, 6, 8, 7, 6, 4, 8, 7, 6, 37, 8},
			{100000}
		};

		int[][] want = new int[][]{
			{1, 47 },
			{0, 0 },
			{2, 18 },
			{5, 86 },
			{10, 249 },
			{1, 100000 }
		};

		for(int i=0; i < T.length; i++){
			int[] got = find(T[i], requiredTime[i]);

			StringBuilder sb = new StringBuilder();
			boolean pass = false;

			if(got[0] == want[i][0] && got[1] == want[i][1]) pass = true;

			sb.append("Case "+i);
			if(pass) sb.append("\tPass");
			else sb.append("\tFail");
			sb.append("\t want: "+Arrays.toString(want[i])+"\t got: "+Arrays.toString(got)+"\n");

			System.out.println(sb.toString());
		}
	}
}