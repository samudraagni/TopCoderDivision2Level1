import java.io.*;

public class WhiteCells{
	public int countOccupied(String[] board){
		int val = 0;
		int len = board.length;

		/* White cells are present in even numbered cells on even numbered rows (starting at row 0) and in odd numbered cells on odd numbered rows */
		for(int i=0; i < len; i++){
			String row = board[i];
			for(int j=0; j < len; j++){
				if(i%2 == 0){
					if(j%2 == 0 && row.charAt(j) == 'F'){
						val++;
					}
				}else{
					if(j%2 == 1 && row.charAt(j) == 'F'){
						val++;
					}
				}
			}
		}

		return val;
	}

	public static void main(String[] args){
		WhiteCells wc = new WhiteCells();
		wc.test();
	}

	private void test(){
		String[] board;
		int expected;
		int obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					board = new String[]{"........", "........", "........", "........", "........", "........", "........", "........"};
					expected = 0;
					obtained = countOccupied(board);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					board = new String[]{"FFFFFFFF", "FFFFFFFF", "FFFFFFFF", "FFFFFFFF", "FFFFFFFF", "FFFFFFFF", "FFFFFFFF", "FFFFFFFF"};
					expected = 32;
					obtained = countOccupied(board);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					board = new String[]{".F.F...F", "F...F.F.", "...F.F.F", "F.F...F.", ".F...F..", "F...F.F.", ".F.F.F.F", "..FF..F."};
					expected = 1;
					obtained = countOccupied(board);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					board = new String[]{"........", "..F.....", ".....F..", ".....F..", "........", "........", ".......F", ".F......"};
					expected = 2;
					obtained = countOccupied(board);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, int expected, int obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Test: "+testNum);
		if(expected == obtained) sb.append("\tSuccess.");
		else sb.append("\tFail.");
		sb.append("\texpected: "+expected+" obtained: "+obtained+"\n");

		System.out.println(sb.toString());


	}
}