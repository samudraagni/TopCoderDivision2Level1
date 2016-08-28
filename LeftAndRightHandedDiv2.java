import java.io.*;

public class LeftAndRightHandedDiv2{
	public int count(String S){
		int val = 0;
		for(int i=0; i < S.length()-1; i++){
			if(S.substring(i,i+2).equals("RL")) val++;
		}
		return val;
	}

	public static void main(String[] args) {
		LeftAndRightHandedDiv2 lrd = new LeftAndRightHandedDiv2();
		lrd.test();
	}

	private void test(){
		String s;
		int expected;
		int obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch(i){
				case 0:{
					s = new String("L");
					expected = 0;
					obtained = count(s);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					s = new String("RRR");
					expected = 0;
					obtained = count(s);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					s = new String("LRLRLR");
					expected = 2;
					obtained = count(s);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					s = new String("LLLRRR");
					expected = 0;
					obtained = count(s);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					s = new String("RLRLRL");
					expected = 3;
					obtained = count(s);
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