import java.io.*;
import java.util.Arrays;

public class DeerInZooDivTwo{
	public int[] getminmax(int N, int K){
		int[] retval = new int[2];
		
		int min = ((N-K > 0)?(N-K):0);

		if(K % 2 == 0) K = K/2;
		else K = K/2 + 1;

		int max = N - K;

		retval[0] = min;
		retval[1] = max;

		return retval;
	}

	public static void main(String[] args) {
		DeerInZooDivTwo diz = new DeerInZooDivTwo();
		diz.test();
	}

	private void test(){
		int N, K;

		int[] expected = new int[2];
		int[] obtained = new int[2];

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					N = 3;
					K = 2;
					expected = new int[]{1, 2};
					obtained = getminmax(N, K);
					//printResult(i, expected, obtained);
					break;
				}
				case 1:{
					N = 3;
					K = 3;
					expected = new int[]{0, 1};
					obtained = getminmax(N, K);
					//printResult(i, expected, obtained);
					break;
				}
				case 2:{
					N = 10;
					K = 0;
					expected = new int[]{10, 10};
					obtained = getminmax(N, K);
					//printResult(i, expected, obtained);
					break;
				}
				case 3:{
					N = 654;
					K = 321;
					expected = new int[]{333, 493};
					obtained = getminmax(N, K);
					//printResult(i, expected, obtained);
					break;
				}
				case 4:{
					N = 100;
					K = 193;
					expected = new int[]{0, 3};
					obtained = getminmax(N, K);
					break;
				}
			}
			printResult(i, expected, obtained);
		}
	}

	private void printResult(int testNum, int[] expected, int[] obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+testNum);
		if(expected[0] == obtained[0] && expected[1] == obtained[1]) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t expected: "+Arrays.toString(expected)+" obtained: "+Arrays.toString(obtained));

		System.out.println(sb.toString());
	}
}