/* Problem stment: https://community.topcoder.com/stat?c=problem_statement&pm=13678 */
import java.io.*;
import java.util.Arrays;

public class ValueOfString{
	public int findValue(String s){
		int[] map = new int[26];
		boolean[] isPresent = new boolean[26];
		Arrays.fill(map, 0);
		Arrays.fill(isPresent, false);

		/* First, mark 1 in the isPresent for the corresponding character in the string.  This will tell me about what characters are there.
		   All n characters are looked at. O(n)
		 */
		for(int i=0; i < s.length(); i++){
			char c = s.charAt(i);
			if(!isPresent[c-'a']) isPresent[c-'a'] = true;
		}
		
		/* Next, go thru the string again. O(n).
		Get the element. Add 1 to itself and all other higher letters in map that are set to 1.
		I have at most 26 elements to set -- constant time */
		for(int i=0; i < s.length(); i++){
			char c = s.charAt(i);
			int j = c-'a';
			if(isPresent[j]){
				while(j < 26){
					map[j]++;
					j++;
				}	
			} 
		}
		
		/* finally go thru the string and the map array to calculate the value. O(n) */
		int value = 0;
		for(int i=0; i < s.length(); i++){
			char c = s.charAt(i);
			int idx = c-'a';
			value += ((idx+1) * map[idx]);
		}

		return value;
	}

	public static void main(String[] args) {
		ValueOfString vs = new ValueOfString();
		vs.test();
	}

	private void test(){
		String[] cases = new String[]{"babca", "zz", "y", "aaabbc", "topcoder", "thequickbrownfoxjumpsoverthelazydog", "zyxwvutsrqponmlkjihgfedcba"};
		int[] want = new int[]{35, 104, 25, 47, 558, 11187, 6201};
		
		for(int i=0; i < cases.length; i++){
			String s = cases[i];
			int got = findValue(s);
			
			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\t want: "+want[i]+"\t got: "+got);

			System.out.println(sb.toString()+"\n");
		}
	}
}
