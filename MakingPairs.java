import java.io.*;

public class MakingPairs{
	public int get(int[] card){
		int val = 0;
		for(int c : card){
			val += (int)(Math.floor(c/2));
		}
		return val;
	}

	public static void main(String[] args){
		MakingPairs mp = new MakingPairs();
		mp.test();
	}

	private void test(){
		int[] card;
		int expected;
		int obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					card = new int[]{2,2,2};
					expected = 3;
					obtained = get(card);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					card = new int[]{1,1,1};
					expected = 0;
					obtained = get(card);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					card = new int[]{5};
					expected = 2;
					obtained = get(card);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					card = new int[]{43,23,10,39,39,22,22,0,3,4,3,2};
					expected = 102;
					obtained = get(card);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					card = new int[]{0};
					expected = 0;
					obtained = get(card);
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