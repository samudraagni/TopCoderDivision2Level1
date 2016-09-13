/* https://community.topcoder.com/stat?c=problem_statement&pm=5988 */

import java.io.*;
import java.util.*;

public class UniqueDigits{
	public int count(int n){

		if(n < 11) return n-1;
		int val = 10;
		for(int i=12; i < n; i++){
			String s = String.valueOf(i);
			HashSet<Character> set = new HashSet<Character>();

			boolean pass = true;
			for(int j=0; j < s.length(); j++){
				if(!set.add(s.charAt(j))){
					pass = false;
					break;
				}
			}
			
			if(pass) val++;
		}
		return val;
	}

	public static void main(String[] args) {
		UniqueDigits ud = new UniqueDigits();
		ud.test();
	}

	private void test(){
		int[] n = new int[]{21, 101, 1001, 1};
		int[] want = new int[]{19, 90, 738, 0};

		for(int i=0; i < n.length; i++){
			int got = count(n[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}