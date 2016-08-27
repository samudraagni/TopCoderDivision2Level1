import java.io.*;

public class KiloMan{
	public int hitsTaken(int[] pattern, String jumps){
		int len = pattern.length;
		int numhits = 0;

		for(int i=0; i < len; i++){
			int shotHeight = pattern[i];
			char action = jumps.charAt(i);

			if(shotHeight <= 2 && action == 'S') numhits++;
			else if(shotHeight > 2 && action == 'J') numhits++;
		}

		return numhits;
	}

	public static void main(String[] args){
		KiloMan km = new KiloMan();
		km.test();
	}

	private void test(){
		int[] pattern;
		String jumps;
		int expected;
		int obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					pattern = new int[]{1,3,2,3,3,1,2,2,1};
					jumps = new String("JJSSSJSSJ");
					expected = 4;
					obtained = hitsTaken(pattern, jumps);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					pattern = new int[]{1,1,1,1,1,1,1,2,2,2,2,2,2,2,3,3,3,3,3,3,3,4,4,4,4,4,4,4,5,5,5,5,5,5,5,6,6,6,6,6,6,6,7,7,7,7,7,7,7};
					jumps = new String("SSSSSSSSSSSSSSJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ");
					expected = 49;
					obtained = hitsTaken(pattern, jumps);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					pattern = new int[]{1,2,2,1};
					jumps = new String("SJJS");
					expected = 2;
					obtained = hitsTaken(pattern, jumps);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					pattern = new int[]{1};
					jumps = new String("J");
					expected = 0;
					obtained = hitsTaken(pattern, jumps);
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