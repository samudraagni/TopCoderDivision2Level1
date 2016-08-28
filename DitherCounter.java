import java.io.*;
import java.util.Arrays;

public class DitherCounter{
	public int count(String dithered, String[] screen){
		int[] dcount = new int[26];

		/* initialize dcount to -1. Set letters that appear in dithered to zero.
		Scan the screen and increment val if dithered is zero */
		Arrays.fill(dcount, -1);

		for(int i=0; i < dithered.length(); i++){
			dcount[dithered.charAt(i)-'A'] = 0;
		}

		int val = 0;
		for(int i=0; i < screen.length; i++){
			String s = screen[i];
			for(int j=0; j < s.length(); j++){
				if(dcount[s.charAt(j)-'A'] == 0){
					val++;
				}
			}
		}

		return val;
	}

	public static void main(String[] args) {
		DitherCounter dc = new DitherCounter();
		dc.test();
	}

	private void test(){
		String dithered;
		String[] screen;
		int expected;
		int obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					dithered = new String("BW");
					screen = new String[]{"AAAAAAAA",
										 "ABWBWBWA",
										 "AWBWBWBA",
										 "ABWBWBWA",
										 "AWBWBWBA",
										 "AAAAAAAA"};
					expected = 24;
					obtained = count(dithered, screen);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					dithered = new String("BW");
					screen = new String[]{"BBBBBBBB",
										 "BBWBWBWB",
										 "BWBWBWBB",
										 "BBWBWBWB",
										 "BWBWBWBB",
										 "BBBBBBBB"};
					expected = 48;
					obtained = count(dithered, screen);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					dithered = new String("ACEGIKMOQSUWY");
					screen = new String[]{"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX"};
					expected = 150;
					obtained = count(dithered, screen);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					dithered = new String("CA");
					screen = new String[]{"BBBBBBB",
 "BBBBBBB",
 "BBBBBBB"};
					expected = 0;
					obtained = count(dithered, screen);
					printResult(i, expected, obtained);
					break;
				}
				case 5:{
					dithered = new String("DCBA");
					screen = new String[]{"ACBD"};
					expected = 4;
					obtained = count(dithered, screen);
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