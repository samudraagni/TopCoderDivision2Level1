/* https://community.topcoder.com/stat?c=problem_statement&pm=12424 */

public class Chopsticks{
	public int getmax(int[] length){
		if(length.length <= 1) return 0;
		int count = 0;
		int[] seen = new int[101];

		for(int i : length){
			seen[i]++;
		}

		for(int i:seen){
			count += i/2;
		}

		return count;
	}

	public static void main(String[] args){
		Chopsticks cs = new Chopsticks();
		cs.test();
	}

	private void test(){
		int[][] length = new int[][]{
			{5,5},
			{1,2,3,2,1,2,3,2,1},
			{1},
			{1,2,3,4,5,6,7,8,9},
			{35,35,35,50,16,30,10,10,35,50,16,16,16,30,50,30,16,35,50,30,10,50,50,16,16,
10,35,50,50,50,16,35,35,30,35,10,50,10,50,50,16,30,35,10,10,30,10,10,16,35}
		};

		int[] want = new int[]{1, 4, 0, 0, 24};

		for(int i=0; i < length.length; i++){
			int got = getmax(length[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t want: "+want[i]+"\t got: "+got);

			System.out.println(sb.toString());
		}
	}
}