import java.io.*;

public class KitayutaMart2{
	public int numBought(int K, int T){
		int lv = T/K + 1;
		int val = (int)(Math.log(lv)/Math.log(2));
		return val;
	}

	public static void main(String[] args){
		KitayutaMart2 km = new KitayutaMart2();
		km.test();
	}

	private void test(){
		int K;
		int T;
		int expected;
		int obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					K = 100;
					T = 100;
					expected = 1;
					obtained = numBought(K,T);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					K = 100;
					T = 300;
					expected = 2;
					obtained = numBought(K,T);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					K = 150;
					T = 1050;
					expected = 3;
					obtained = numBought(K,T);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					K = 160;
					T = 163680;
					expected = 10;
					obtained = numBought(K,T);
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