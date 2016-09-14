/* https://community.topcoder.com/stat?c=problem_statement&pm=6109 */

import java.io.*;

public class ThreeCardMonte{
	public String position(String swaps){
		int[] vals = new int[]{0, 1, 0};// initial configuration

		for(int i=0; i < swaps.length(); i++){
			char c = swaps.charAt(i);

			if(c == 'L'){
				int temp = vals[0];
				vals[0] = vals[1];
				vals[1] = temp;
			}
			else if(c == 'R'){
				int temp = vals[1];
				vals[1] = vals[2];
				vals[2] = temp;
			}
			else if(c == 'E'){
				int temp = vals[0];
				vals[0] = vals[2];
				vals[2] = temp;
			}
		}

		if(vals[0] == 1) return "L";
		else if(vals[2] == 1) return "R";

		return "M";
	}

	public static void main(String[] args) {
		ThreeCardMonte tcm = new ThreeCardMonte();
		tcm.test();
	}

	private void test(){
		String[] swaps = new String[]{
			"L",
			"REL",
			"RFRFR",
			"",
			"FLRELFLRELLFRLFEELFLRFLELRFLRFREFRFLLRFERLFLREFRFL"
		};

		String[] want = new String[]{"L", "M", "R", "M", "L"};

		for(int i=0; i < swaps.length; i++){
			String got = position(swaps[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got.equals(want[i])) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\t got "+got+"\t want "+want[i]);

			System.out.println(sb.toString());
		}
	}
}