/* https://community.topcoder.com/stat?c=problem_statement&pm=13556 */

public class ChristmasTreeDecorationDiv2{
	public int solve(int[] col, int[] x, int[] y){

		int num = 0;
		for(int i=0; i < x.length; i++){
			if(col[x[i]-1] != col[y[i]-1]){
				num++;
			}
		}

		return num;
	}

	public static void main(String[] args) {
		ChristmasTreeDecorationDiv2 ctd = new ChristmasTreeDecorationDiv2();
		ctd.test();
	}

	private void test(){
		int[][] col = new int[][]{
			{1,2,3,3},
			{1,3,5},
			{1,1,3,3},
			{5,5,5,5},
			{9,1,1}
		};

		int[][] x = new int[][]{
			{1,2,3},
			{1,3},
			{1,3,2},
			{1,2,3},
			{3,2}
		};

		int[][] y = new int[][]{
			{2,3,4},
			{2,2},
			{2,1,4},
			{2,3,4},
			{2,1}
		};

		int[] want = new int[]{2, 2, 2, 0, 1};

		for(int i=0; i < col.length; i++){
			int got = solve(col[i], x[i], y[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}