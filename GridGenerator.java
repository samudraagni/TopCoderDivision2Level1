import java.io.*;

public class GridGenerator{
	public int generate(int[] row, int[] col){
		int[][] vals = new int[row.length][col.length];

		for(int i=0; i < row.length; i++){
			vals[i][0] = row[i];
		}

		for(int i=0; i < col.length; i++){
			vals[0][i] = col[i];
		}

		for(int i=1; i < row.length; i++){
			for(int j=1; j < col.length; j++){
				        /* left        + above	      + above-left */ 
				int val = vals[i][j-1] + vals[i-1][j] + vals[i-1][j-1];
				vals[i][j] = val;
			}
		}

		return vals[row.length-1][col.length-1];
	}

	public static void main(String[] args){
		GridGenerator gg = new GridGenerator();
		gg.test();
	}

	private void test(){
		int[] row;
		int[] col;
		int expected;
		int obtained;

		int numTests = 3;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					row = new int[]{1,0,3,4,1};
					col = new int[]{1,4,1,0,3};
					expected = 579;
					obtained = generate(row, col);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					row = new int[]{9,9,9,9,9,9,9,9,9,9};
					col = new int[]{9,9,9,9,9,9,9,9,9,9};
					expected = 13163067;
					obtained = generate(row, col);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					row = new int[]{0,0,0,0,0,0,0,0,0};
					col = new int[]{0,0,0,0,0,0,0,0,0};
					expected = 0;
					obtained = generate(row, col);
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