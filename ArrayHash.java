import java.io.*;

public class ArrayHash{
	public int getHash(String[] input){
		int val = 0;
		for(int i=0; i < input.length; i++){
			String s = input[i];
			for(int j=0; j < s.length(); j++){
				val += (s.charAt(j)-'A') + i + j;
			}
		}
		return val;
	}

	public static void main(String[] args){
		ArrayHash ah = new ArrayHash();
		ah.test();
	}

	private void test(){
		String[] input;
		int expected;
		int obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					input = new String[]{"CBA","DDD"};
					expected = 21;
					obtained = getHash(input);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					input = new String[]{"Z"};
					expected = 25;
					obtained = getHash(input);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					input = new String[]{"A", "B", "C", "D", "E", "F"};
					expected = 30;
					obtained = getHash(input);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					input = new String[]{"ABCDEFGHIJKLMNOPQRSTUVWXYZ",
										 "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
										 "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
										 "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
										 "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
										 "ABCDEFGHIJKLMNOPQRSTUVWXYZ"};
					expected = 4290;
					obtained = getHash(input);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					input = new String[]{"ZZZZZZZZZZ"};
					expected = 295;
					obtained = getHash(input);
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
		sb.append("\texpected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}