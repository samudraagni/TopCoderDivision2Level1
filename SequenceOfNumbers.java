/* https://community.topcoder.com/stat?c=problem_statement&pm=4659 */

import java.io.*;
import java.util.Arrays;

public class SequenceOfNumbers{
	public String[] rearrange(String[] sequence){
		long[] vals = new long[sequence.length];

		for(int i=0; i < sequence.length; i++){
			vals[i] = Long.parseLong(sequence[i]);
		}

		Arrays.sort(vals);

		String[] retval = new String[sequence.length];
		for(int i=0; i < vals.length; i++){
			retval[i] = String.valueOf(vals[i]);
		}

		return retval;
	}

	public static void main(String[] args) {
		SequenceOfNumbers son = new SequenceOfNumbers();
		son.test();
	}

	private void test(){
		String[][] sequence = new String[][]{
			{"1","174","23","578","71","9"},
			{"172","172","172","23","23"},
			{"183","2","357","38","446","46","628","734","741","838"}
		};

		String[][] want = new String[][]{
			{"1", "9", "23", "71", "174", "578"},
			{"23", "23", "172", "172", "172"},
			{"2", "38", "46", "183", "357", "446", "628", "734", "741", "838"}
		};

		for(int i=0; i < sequence.length; i++){
			String[] got = rearrange(sequence[i]);

			boolean pass = true;
			if(got.length != sequence[i].length) {
				pass = false;
			}
			else{
				for(int j=0; j < got.length; j++){
					if(!(got[j].equals(want[i][j]))) {
						pass = false;
						break;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(pass) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\n got: "+Arrays.toString(got)+"\n want: "+Arrays.toString(want[i]));

			System.out.println(sb.toString());
		}
	}
}	