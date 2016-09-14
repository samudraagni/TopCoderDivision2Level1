/* https://community.topcoder.com/stat?c=problem_statement&pm=11628 */

import java.io.*;
import java.util.Arrays;

public class CheatingQuiz{
	public 	int[] howMany(String answers){
		/* count number of A, B, and Cs */
		int aCount = 0;
		int bCount = 0;
		int cCount = 0;

		int alen = answers.length();

		for(int i=0; i < alen; i++){
			char c = answers.charAt(i);
			if(c == 'A') aCount++;
			else if(c == 'B') bCount++;
			else if(c == 'C') cCount++;
		}

		int numOptions = aCount + bCount + cCount;

		/* scan the string to check how many options are left */
		int[] retval = new int[alen];
		Arrays.fill(retval, 0);
		for(int i=0; i < alen; i++){
			char c = answers.charAt(i);

			int numremaining = 0;
			if(aCount > 0) numremaining++;
			if(bCount > 0) numremaining++;
			if(cCount > 0) numremaining++;

			retval[i] = numremaining;

			if(c == 'A') --aCount;
			else if(c == 'B') --bCount;
			else if(c == 'C') --cCount;
		}

		return retval;
	}

	public static void main(String[] args) {
		CheatingQuiz cq = new CheatingQuiz();
		cq.test();
	}

	private void test(){
		String[] answers = new String[]{
			"AAAAA",
			"AAABBB",
			"CAAAAAC",
			"BBCA",
			"BACACABCBBBBCAAAAACCCABBCAA"
		};

		int[][] want = new int[][]{
			{1, 1, 1, 1, 1 },
			{2, 2, 2, 1, 1, 1 },
			{2, 2, 2, 2, 2, 2, 1 },
			{3, 3, 2, 1 },
			{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 1, 1 }
		};

		for(int i=0; i < answers.length; i++){
			int[] got = howMany(answers[i]);

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
			sb.append("\n want: "+Arrays.toString(want[i])+"\n got: "+Arrays.toString(got)+"\n");

			System.out.println(sb.toString());
		}
	}
}