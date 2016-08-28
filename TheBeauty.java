import java.io.*;
import java.util.Arrays;

public class TheBeauty{
	public 	int find(int n){
		int[] map = new int[10];
		Arrays.fill(map,0);

		int count = 0;
		String s = String.valueOf(n);
		for(int i=0; i < s.length(); i++){
			if(map[s.charAt(i)-'0'] == 0){
				map[s.charAt(i)-'0'] = 1;
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args){
		TheBeauty tb = new TheBeauty();
		tb.test();
	}

	private void test(){
		int n;
		int expected;
		int obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					n = 7;
					expected = 1;
					obtained = find(n);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					n = 100;
					expected = 2;
					obtained = find(n);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					n = 123456789;
					expected = 9;
					obtained = find(n);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					n = 1000000000;
					expected = 2;
					obtained = find(n);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					n = 932400154;
					expected = 7;
					obtained = find(n);
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