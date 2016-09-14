/* https://community.topcoder.com/stat?c=problem_statement&pm=12508 */

import java.io.*;
import java.util.Arrays;


public class TheExperimentDiv2{
	public 	int[] determineHumidity(int[] intensity, int L, int[] leftEnd){

		int[][] setup = new int[leftEnd.length][intensity.length];
		
		for(int i=0; i < leftEnd.length; i++){
			int start = leftEnd[i];
			int end = start + L;

			for(int j=0; j < start; j++) {
				setup[i][j] = 0;
			}

			for(int j=start; j < end; j++){
				/* check if anything above me has been set */
				boolean set = false;
				for(int k=i-1; k >= 0; k--){
					if(setup[k][j] == 1){
						set = true;
						break;
					}
				}

				if(!set) setup[i][j] = 1;
				else setup[i][j] = 0;
			}

			for(int j=end; j < intensity.length; j++){
				setup[i][j] = 0;
			}
		}

		int[] retval = new int[leftEnd.length];
		for(int i=0; i < leftEnd.length; i++){
			for(int j=0; j < intensity.length; j++){
				retval[i] += (setup[i][j] * intensity[j]);
			}
		}

		return retval;
	}

	public static void main(String[] args) {
		TheExperimentDiv2 ted = new TheExperimentDiv2();
		ted.test();
	}

	private void test(){
		int[][] intensity = new int[][]{
			{3, 4, 1, 1, 5, 6},
			{5, 5},
			{92, 11, 1000, 14, 3},
			{2, 6, 15, 10, 8, 11, 99, 2, 4, 4, 4, 13}
		};

		int[] L = new int[]{
			3,
			2,
			2,
			4
		};

		int[][] leftEnd = new int[][]{
			{3, 1, 0},
			{0, 0},
			{0, 3},
			{1, 7, 4, 5, 8, 0}
		};

		int[][] want = new int[][]{
			{12, 5, 3 },
			{10, 0 },
			{103, 17 },
			{39, 14, 110, 0, 13, 2 }
		};

		for(int i=0; i < intensity.length; i++){
			int[] got = determineHumidity(intensity[i], L[i], leftEnd[i]);

			boolean pass = true;
			if(got.length != want[i].length) pass = false;
			else{
				for(int j=0; j < got.length; j++){
					if(got[j] != want[i][j]){
						pass = false;
						break;
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(pass) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\n Got: "+Arrays.toString(got)+"\n want: "+Arrays.toString(want[i]));

			System.out.println(sb.toString());
		}
	}
}