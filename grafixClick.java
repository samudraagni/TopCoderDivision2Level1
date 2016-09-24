/* https://community.topcoder.com/stat?c=problem_statement&pm=2996 */


import java.util.*;

public class grafixClick{
	public int[] checkSaveButton(int[] mouseRows, int[] mouseCols){
		int top = 20;
		int bottom = 39;
		int left = 50;
		int right = 99;

		ArrayList<Integer> clicks = new ArrayList<Integer>();

		for(int i=0; i < mouseRows.length; i++){
			int x = mouseRows[i];
			int y = mouseCols[i];

			if(x >= top && x <= bottom && y >= left && y <= right){
				clicks.add(i);
			}
		}

		int[] retval = new int[clicks.size()];
		for(int i=0; i < clicks.size(); i++){
			retval[i] = clicks.get(i);
		}

		Arrays.sort(retval);

		return retval;
	}

	public static void main(String[] args) {
		grafixClick gc = new grafixClick();
		gc.test();
	}

	private void test(){
		int[][] mouseRows = new int[][]{
			{20, 39, 100},
			{0, 100, 399},
			{30},
			{10, 20, 30, 30, 30, 30, 34, 35, 345},
			{57, 28, 18, 25, 36, 12, 33, 44, 13, 32,
			 32, 51, 11, 27, 8, 51, 17, 34, 10, 16,
			 47, 57, 20, 57, 32, 14, 13, 37, 10, 16,
			 49, 37, 52, 8, 18, 44, 50, 43, 11, 1,
			 21, 22, 17, 35, 28, 53, 56, 16, 11, 44}
		};

		int[][] mouseCols = new int[][]{
			{99, 50, 200},
			{0, 200, 599},
			{75},
			{10, 20, 30, 50, 60, 80, 34, 35, 345},
			{146, 22, 41, 88, 123, 99, 43, 110, 25, 64,
			 141, 110, 70, 34, 99, 103, 60, 64, 142, 109,
			 133, 144, 72, 68, 25, 32, 21, 140, 30, 105,
			 32, 72, 114, 97, 35, 131, 103, 110, 133, 81,
			 125, 36, 76, 78, 77, 47, 50, 94, 22, 20}
		};

		int[][] want = new int[][]{
			{ 0,  1 },
			{ },
			{ 0 },
			{ 3,  4,  5 },
			{ 3,  9,  17,  22,  31,  43,  44 }
		};

		for(int i=0; i < mouseRows.length; i++){
			int[] got = checkSaveButton(mouseRows[i], mouseCols[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			boolean pass = true;
			if(got.length != want[i].length) pass = false;
			else{
				for(int j=0; j < got.length; j++){
					if(got[j] != want[i][j]){
						pass = false;
						break;
					}
				}
			}
			if(pass) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\n want:"+Arrays.toString(want[i])+"\n got: "+Arrays.toString(got));

			System.out.println(sb.toString());
		}
	}
}