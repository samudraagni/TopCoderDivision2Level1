/* https://community.topcoder.com/stat?c=problem_statement&pm=10899 */

public class TheMoviesLevelOneDivTwo{
	public int find(int n, int m, int[] row, int[] seat){
		int[][] taken = new int[n+1][m+1];
		for(int i=0; i < n+1; i++){
			for(int j=0; j < m+1; j++){
				taken[i][j] = 0;
			}
		}

		/* fill row and seats */
		for(int i=0; i < row.length; i++){
			taken[row[i]][seat[i]] = 1;
		}

		/* find seats that are empty and next to each other */
		int empty = 0;
		for(int i=1; i < n+1; i++){
			for(int j=1; j < m; j++){
				if(taken[i][j] == 0 && taken[i][j+1] == 0){
					empty++;
				}
			}
		}

		return empty;
	}

	public static void main(String[] args) {
		TheMoviesLevelOneDivTwo tml = new TheMoviesLevelOneDivTwo();
		tml.test();
	}

	private void test(){
		int[] n = new int[]{2, 2, 4, 10};
		int[] m = new int[]{3, 3, 7, 8};
		int[][] row = new int[][]{
			{1, 2},
			{1, 1, 1, 2, 2, 2},
			{1},
			{1, 9, 6, 10, 6, 7, 9, 3, 9, 2}
		};
		int[][] seat = new int[][]{
			{2, 3},
			{1, 2, 3, 1, 2, 3},
			{1},
			{7, 7, 3, 3, 7, 1, 5, 1, 6, 2}
		};
		int[] want = new int[]{1, 0, 23, 54};

		for(int i=0; i < n.length; i++){
			int got = find(n[i], m[i], row[i], seat[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}