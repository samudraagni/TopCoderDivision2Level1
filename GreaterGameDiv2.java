import java.io.*;

public class GreaterGameDiv2{
	
	public int calc(int[] snuke, int[] sothe){

		int maxPoints = 0;

		for(int i=0; i < snuke.length; i++){
			if(snuke[i] > sothe[i]){
				maxPoints++;
			}
		}

		return maxPoints;
	}

	public static void main(String[] args){

		GreaterGameDiv2 g = new GreaterGameDiv2();
		g.test();
	}

	private void test(){

		int[] snuke;
		int[] sothe;
		int expected;
		int obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					snuke = new int[]{1,3};
					sothe = new int[]{4,2};
					expected = 1;
					obtained = calc(snuke, sothe);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					snuke = new int[]{1,3,5,7,9};
					sothe = new int[]{2,4,6,8,10};
					expected = 0;
					obtained = calc(snuke, sothe);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					snuke = new int[]{2};
					sothe = new int[]{1};
					expected = 1;
					obtained = calc(snuke, sothe);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					snuke = new int[]{3,5,9,16,14,20,15,17,13,2};
					sothe = new int[]{6,18,1,8,7,10,11,19,12,4};
					expected = 6;
					obtained = calc(snuke, sothe);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, int expected, int obtained){

		StringBuilder sb = new StringBuilder();

		sb.append("\nTest no. "+testNum);

		if(expected == obtained) sb.append("\tSuccess.");
		else sb.append("\tFail.");

		sb.append("\texpected: "+expected+" obtained: "+obtained+"\n");

		System.out.println(sb.toString());
	}
}