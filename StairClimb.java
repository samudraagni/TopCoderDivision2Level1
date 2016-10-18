/* https://community.topcoder.com/stat?c=problem_statement&pm=1937 */

public class StairClimb{
	public 	int stridesTaken(int[] flights, int stairsPerStride){

		if(flights.length == 0) return 0;

		int numStrides = 0;
		for(int flight : flights){
			int q  = flight/stairsPerStride;
			int r = ((flight % stairsPerStride) > 0)? 1 : 0;

			numStrides += q + r + 2;
		}

		//last landing does not require turn around
		numStrides -= 2;

		return numStrides;
	}

	public static void main(String[] args){
		StairClimb sc = new StairClimb();
		sc.test();
	}

	private void test(){
		int[][] flights = new int[][]{
			{15},
			{15,15},
			{5,11,9,13,8,30,14}
		};

		int[] stairsPerStride = new int[]{
			2,
			2,
			3
		};

		int[] want = new int[]{
			8, 18, 44
		};

		for(int i=0; i < flights.length; i++){
			int got = stridesTaken(flights[i], stairsPerStride[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\tgot:\t"+got+"\twant:\t"+want[i]);

			System.out.println(sb.toString()+"\n");
		}
	}

}