import java.io.*;

public class RosePetals{
	public int getScore(int[] dice){
		int val = 0;
		for(int i=0; i < dice.length; i++){
			val += (dice[i] == 3? 2:(dice[i] == 5 ?4:0));
		}
		return val;
	}

	public static void main(String[] args){
		RosePetals rp = new RosePetals();
		rp.test();
	}

	private void test(){
		int[] dice;
		int expected;
		int obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					dice = new int[]{1, 2, 3, 2, 1};
					expected = 2;
					obtained = getScore(dice);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					dice = new int[]{4, 4, 5, 6, 5};
					expected = 8;
					obtained = getScore(dice);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					dice = new int[]{1, 2, 3, 3, 5};
					expected = 8;
					obtained = getScore(dice);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					dice = new int[]{3, 3, 3, 3, 3};
					expected = 10;
					obtained = getScore(dice);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					dice = new int[]{2, 2, 2, 2, 2};
					expected = 0;
					obtained = getScore(dice);
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
		sb.append("\texpected: "+expected+" obtained:"+obtained);

		System.out.println(sb.toString());
	}
}