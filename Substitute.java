/* Problem statement: https://community.topcoder.com/stat?c=problem_statement&pm=1333 */
import java.io.*;
import java.lang.Integer;
import java.util.Arrays;

public class Substitute{
	public int getValue(String key, String code){
		StringBuilder sb = new StringBuilder();

		/* this avoids indexOf() */		
		int[] charMap = new int[26];
		Arrays.fill(charMap, -1);
		
		int len = key.length();
		
		for(int i=0; i < len; i++){
			int idx = key.charAt(i)-'A';
			charMap[idx] = (i+1) % len;//1-based index
		}

		for(int i=0; i < code.length(); i++){
			int val = charMap[code.charAt(i)-'A'];
			if(val != -1){
				sb.append(val);	
			}
		}

		Integer val = Integer.valueOf(sb.toString());
		return val.intValue();
	}

	public static void main(String[] args) {
		Substitute sb = new Substitute();
		sb.test();
	}

	private void test(){

		String[] keys = new String[]{"TRADINGFEW", "ABCDEFGHIJ", "CRYSTALBUM"};
		String[] codes = new String[]{"LGXWEV", "XJ", "MMA"};
		int[] want = new int[]{709, 0, 6};

		for(int i=0; i < keys.length; i++){
			int got = getValue(keys[i], codes[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\t want: "+want[i]+"\t got: "+got);

			System.out.println(sb.toString()+"\n");
		}
	}
}