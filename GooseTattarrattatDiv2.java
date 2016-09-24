/* https://community.topcoder.com/stat?c=problem_statement&pm=12733 */

import java.util.Arrays;

public class GooseTattarrattatDiv2{
	public int getmin(String S){
		int[] freq = new int[26];
		Arrays.fill(freq, 0);

		int max = Integer.MIN_VALUE;
		int maxpos = -1;
		for(int i=0; i < S.length(); i++){
			int index = S.charAt(i)-'a';
			freq[index]++;

			if(freq[index] > max){
				max = freq[index];
				maxpos = index;
			}
		}

		int change = 0;
		for(int i=0; i < 26; i++){
			if(freq[i] != max){
				change += freq[i];
			}
			else if(freq[i] == max){
				//in case there are more than one 
				if(i != maxpos){
					change += freq[i];
				}
			}
		}

		return change;
	}
	
	public static void main(String[] args) {
		GooseTattarrattatDiv2 gtd = new GooseTattarrattatDiv2();
		gtd.test();
	}

	private void test(){
		String[] S = new String[]{
			"geese",
			"tattarrattat",
			"www",
			"topcoder",
			"xrepayuyubctwtykrauccnquqfuqvccuaakylwlcjuyhyammag"
		};

		int[] want = new int[]{2, 6, 0, 6, 43};

		for(int i=0; i < S.length; i++){
			int got = getmin(S[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}