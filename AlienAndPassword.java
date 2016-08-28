import java.io.*;
import java.util.*;

public class AlienAndPassword{
	public int getNumber(String S){

		if(S.length() == 1) return 1;

		HashSet<String> set = new HashSet<String>();
		for(int i=0; i < S.length(); i++){
			String sb = new String();
			
			sb = S.substring(0,i);
			sb += S.substring(i+1);
			
			set.add(sb.toString());
		}
		return set.size();
	}

	public static void main(String[] args) {
		AlienAndPassword aap = new AlienAndPassword();
		aap.test();
	}

	private void test(){
		String s;
		int expected;
		int obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					s = new String("A");
					expected = 1;
					obtained = getNumber(s);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					s = new String("ABA");
					expected = 3;
					obtained = getNumber(s);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					s = new String("AABACCCCABAA");
					expected = 7;
					obtained = getNumber(s);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					s = new String("AGAAGAHHHHFTQLLAPUURQQRRRUFJJSBSZVJZZZ");
					expected = 26;
					obtained = getNumber(s);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					s = new String("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
					expected = 1;
					obtained = getNumber(s);
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
		sb.append("\t expected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}
