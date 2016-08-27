import java.io.*;

public class LetterStrings{
	public 	int sum(String[] s){
		int len = s.length;
		int val = 0;

		for(int i=0; i < len; i++){
			String sv = s[i];

			/* I could use contains() to check first and then add string length if it does not contain '-'.
			String contains is O(n).  I might as well just use that time to add the value */
			for(int j=0; j < sv.length(); j++){
				if(sv.charAt(j) != '-') val++;
			}
		}

		return val;
	}

	public static void main(String[] args){
		LetterStrings ls = new LetterStrings();
		ls.test();
	}

	private void test(){
		String[] s;
		int expected;
		int obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					s = new String[]{"-"};
					expected = 0;
					obtained = sum(s);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					s = new String[]{"A"};
					expected = 1;
					obtained = sum(s);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					s = new String[]{"-----Abc"};
					expected = 3;
					obtained = sum(s);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					s = new String[]{"-A-B-C-D", "--------EFGHI", "JKLMNOPQR", "---STU-VW-XYZ"};
					expected = 26;
					obtained = sum(s);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, int expected, int obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+testNum);
		if(expected == obtained) sb.append("\tSuccess");
		else sb.append("\tFail");
		sb.append("\texpected "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}