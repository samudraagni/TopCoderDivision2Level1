/* https://community.topcoder.com/stat?c=problem_statement&pm=13391 
	249.99/250

*/

public class RunningAroundPark{
	public int numberOfLap(int N, int[] d){

		int laps = 1;
		for(int i=0; i < d.length-1; i++){
			if(d[i] >= d[i+1]){
				laps++;
			}
		}

		return laps;
	}

	public static void main(String[] args){
		RunningAroundPark rap = new RunningAroundPark();
		rap.test();
	}

	private void test(){
		int[] N = new int[]{3, 24, 3, 50};
		int[][] d = new int[][]{
			{1,2,3},
			{6,6},
			{3,2,1},
			{1,3,5,7,9,2,4,6,8,10}
		};

		int[] want = new int[]{1, 2, 3, 2};

		for(int i=0; i < N.length; i++){
			int got = numberOfLap(N[i], d[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}