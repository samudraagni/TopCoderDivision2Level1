/* https://community.topcoder.com/stat?c=problem_statement&pm=2306 */

import java.util.Arrays;

public class IBEvaluator{
	public int[] getSummary(int[] predictedGrades, int[] actualGrades){
		int[] numDiff = new int[7];
		for(int i=0; i < 7; i++) {
			numDiff[i] = 0;
		}

		for(int i=0; i < predictedGrades.length; i++){
			int diff = Math.abs(predictedGrades[i] - actualGrades[i]);
			numDiff[diff]++;
		}

		int len = predictedGrades.length;
		int[] retval = new int[7];
		for(int i=0; i < numDiff.length; i++){
			retval[i] = (int)(100 * ((double)numDiff[i]/len));
		}

		return retval;
	}

	public static void main(String[] args){
		IBEvaluator ibe = new IBEvaluator();
		ibe.test();
	}

	private void test(){
		int[][] predictedGrades = new int[][]{
			{1,5,7,3},
			{1,1,1},
			{3},
			{1,5,3,5,6,4,2,5,7,6,5,2,3,4,1,4,6,5,4,7,6,6,1}
		};

		int[][] actualGrades = new int[][]{
			{3,5,4,5},
			{5,6,7},
			{3},
			{5,1,3,2,6,4,1,7,5,2,7,4,2,6,5,7,3,1,4,6,3,1,7}
		};


		int[][] want = new int[][]{
			{ 25,  0,  50,  25,  0,  0,  0 },
			{ 0,  0,  0,  0,  33,  33,  33 },
			{ 100,  0,  0,  0,  0,  0,  0 },
			{ 17,  13,  21,  17,  21,  4,  4 }
		};

		for(int i=0; i < predictedGrades.length; i++){
			int[] got = getSummary(predictedGrades[i], actualGrades[i]);

			boolean pass = true;
			for(int j=0; j < got.length; j++){
				if(got[j] != want[i][j]) {
					pass = false;
					break;
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(pass) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\n got:\t"+Arrays.toString(got)+"\n want:\t"+Arrays.toString(want[i])+"\n");

			System.out.println(sb.toString());
		}
	}
}