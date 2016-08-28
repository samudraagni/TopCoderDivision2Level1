import java.io.*;
import java.util.*;

public class SoccerLeagues{
	public int[] points(String[] matches){

		int[] vals = new int[matches.length];
		Arrays.fill(vals, 0);

		int i = 0;
		for(String s:matches){
			for(int j=0; j < s.length(); j++){
				char c = s.charAt(j);
				if(c != '-'){
					if(c == 'W'){
						vals[i] += 3;
					}
					else if(c == 'D'){
						vals[i] += 1;
						vals[j] += 1;
					}
					else if(c == 'L'){
						vals[j] += 3;
					}
				}
			}
			i++;
		}
		return vals;
	}

	public static void main(String[] args){
		SoccerLeagues sl = new SoccerLeagues();
		sl.test();
	}

	private void test(){
		String[] matches;
		int[] expected;
		int[] obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					matches = new String[]{"-WW","W-W","WW-"};
					expected = new int[]{6, 6, 6 };
					obtained = points(matches);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					matches = new String[]{"-DD", "L-L", "WD-"};
					expected = new int[]{5, 2, 8 };
					obtained = points(matches);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					matches = new String[]{"-DWWD", "L-WLL", "DD-WD", "DDL-L", "DDLL-"};
					expected = new int[]{14, 7, 12, 8, 10 };
					obtained = points(matches);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					matches = new String[]{"-LWWLWDLDWWWWWWDDWDW",
											"D-WWLDDWDWDLWDDWLWDD",
											"LL-DLDWDLDLDWWWLWDDW",
											"LDD-LLLDLWLWWWWDWDWL",
											"LWWW-DWDLWDWDWWWDWDW",
											"DLLWD-WWLLDDDLWWDWWW",
											"WWLWDL-LLDWWWWWDWWLW",
											"LLLLLDW-LDLWDDLLLDWL",
											"DWWWWDDD-DWWWWDWWWDW",
											"WWWWLLLWL-LWWWWWLWWW",
											"DWWWWWWWLW-WDWWWWWWW",
											"DDDLLLDWWWL-DDWDWLDD",
											"LWLWLDLLLDLW-DDDWWDD",
											"LLWWLWDDLWLWL-WWWDLL",
											"WWWWLLDDDWLWDD-WWWLW",
											"DLDLLLWWLLLWWLW-DWLL",
											"DLWWWLDLWWDWWDWL-WWD",
											"LLDDLLWLLWLWLDLWW-WW",
											"LLWLLLWWLWLWWDWWLD-W",
											"LLWDLWDWDWLLWWDDWWL-"};
					expected = new int[]{72, 62, 41, 41, 83, 63, 53, 35, 86, 50, 90, 32, 34, 41, 45, 36, 51, 32, 51, 45 };
					obtained = points(matches);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, int[] expected, int[] obtained){
		StringBuilder sb = new StringBuilder();

		boolean match = true;
		for(int i=0; i < expected.length; i++){
			if(expected[i] != obtained[i]){
				match = false;
				break;
			}
		}

		sb.append("Case "+testNum);
		if(match) sb.append("\tSuccess");
		else sb.append("\tFail");
		sb.append("\nExpected: "+Arrays.toString(expected)+"\nObtained: "+Arrays.toString(obtained));

		System.out.println(sb.toString());
	}
}