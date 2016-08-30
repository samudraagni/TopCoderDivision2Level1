import java.io.*;

public class MagicalStringDiv2{
	public int minimalMoves(String S){
		int len = S.length();

		/* Break the string into two parts right in the middle.
		Count the number of '<' in the left part and count the number of '>' in the right part.
		The sum gives the minimal number of moves. */
		String left = S.substring(0,len/2);
		String right = S.substring(len/2, len);

		int moves = 0;
		for(int i=0; i < len/2; i++){
			if(left.charAt(i) == '<') moves++;
			if(right.charAt(i) == '>') moves++;
		} 

		return moves;
	}

	public static void main(String[] args) {
		MagicalStringDiv2 msd = new MagicalStringDiv2();
		msd.test();
	}

	private void test(){
		String S;
		int expected;
		int obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					S = new String(">><<><");
					expected = 2;
					obtained = minimalMoves(S);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					S = new String("<<>>");
					expected = 4;
					obtained = minimalMoves(S);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					S = new String(">>>><<<<");
					expected = 0;
					obtained = minimalMoves(S);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					S = new String("<><<<>>>>><<>>>>><>><<<>><><><><<><<<<<><<>>><><><");
					expected = 20;
					obtained = minimalMoves(S);
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