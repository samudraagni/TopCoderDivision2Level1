import java.io.*;
import java.util.Arrays;

public class DengklekTryingToSleep{
	public int minDucks(int[] ducks){
		int[] vals = new int[101];
		Arrays.fill(vals, -1);

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for(int d : ducks){
			vals[d] = 1;
			if(d > max) max = d;
			if(d < min) min = d;
		}

		/* count -1's between min and max indices */
		int count = 0;
		for(int i=min; i <= max; i++){
			if(vals[i] == -1) count++;
		}

		return count;
	}

	public static void main(String[] args){
		DengklekTryingToSleep dts = new DengklekTryingToSleep();
		dts.test();
	}

	private void test(){
		int[] ducks;
		int expected;
		int obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					ducks = new int[]{5, 3, 2};
					expected = 1;
					obtained = minDucks(ducks);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					ducks = new int[]{58};
					expected = 0;
					obtained = minDucks(ducks);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					ducks = new int[]{9, 3, 6, 4};
					expected = 3;
					obtained = minDucks(ducks);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					ducks = new int[]{7, 4, 77, 47, 74, 44};
					expected = 68;
					obtained = minDucks(ducks);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					ducks = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
					expected = 0;
					obtained = minDucks(ducks);
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