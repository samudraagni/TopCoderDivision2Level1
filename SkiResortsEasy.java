import java.io.*;

public class SkiResortsEasy{
	public int minCost(int[] altitude){
		int val = 0;

		for(int i=0; i < altitude.length-1; i++){
			if(altitude[i] < altitude[i+1]){
				int diff = altitude[i+1] - altitude[i];
				val += diff;

				altitude[i+1] = altitude[i];
			}
		}

		return val;
	}

	public static void main(String[] args){
		SkiResortsEasy sk = new SkiResortsEasy();
		sk.test();
	}

	private void test(){
		int[] altitude;
		int expected;
		int obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0: {
					altitude = new int[]{30, 20, 20, 10};
					expected = 0;
					obtained = minCost(altitude);
					printResult(i, expected, obtained);
					break;
				}
				case 1: {
					altitude = new int[]{5, 7, 3};
					expected = 2;
					obtained = minCost(altitude);
					printResult(i, expected, obtained);
					break;
				}
				case 2: {
					altitude = new int[]{6, 8, 5, 4, 7, 4, 2, 3, 1};
					expected = 6;
					obtained = minCost(altitude);
					printResult(i, expected, obtained);
					break;
				}
				case 3: {
					altitude = new int[]{749, 560, 921, 166, 757, 818, 228, 584, 366, 88};
					expected = 2284;
					obtained = minCost(altitude);
					printResult(i, expected, obtained);
					break;
				}
				case 4: {
					altitude = new int[]{712, 745, 230, 200, 648, 440, 115, 913, 627, 621, 186, 222, 741, 954, 581, 193, 266, 320, 798, 745};
					expected = 6393;
					obtained = minCost(altitude);
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
		sb.append("\tExpected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}