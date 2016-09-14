/* https://community.topcoder.com/stat?c=problem_statement&pm=10295 */

import java.io.*;
import java.util.Arrays;

public class GroupedWordChecker{
	public 	int howMany(String[] words){
		int count = 0;

		for(String s : words){
			int[] charPos = new int[26];
			Arrays.fill(charPos, -1);

			boolean grouped = true;
			for(int i=0; i < s.length(); i++){
				int c = s.charAt(i) - 'a';
				if(charPos[c] == -1) charPos[c] = i;
				else if(i - charPos[c] > 1) {
					grouped = false;
					break;
				}
				else if(i - charPos[c] == 1){
					charPos[c] = i;//update to the new index
				}
			}

			if(grouped) count++;
		}

		return count;
	}

	public static void main(String[] args) {
		GroupedWordChecker gwc = new GroupedWordChecker();
		gwc.test();
	}

	private void test(){
		String[][] words = new String[][]{
			{"ccazzzzbb", "code", "aabbbccb", "topcoder"},
			{"ab", "aa", "aca", "ba", "bb"},
			{"happy", "new", "year"},
			{"yzyzy", "zyzyz"},
			{"z"}
		};

		int[] want = new int[]{2, 4, 3, 0, 1};

		for(int i=0; i < words.length; i++){
			int got = howMany(words[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t want: "+want[i]+"\t got: "+got);

			System.out.println(sb.toString());
		}
	}
}