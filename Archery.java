/* https://community.topcoder.com/stat?c=problem_statement&pm=10586 */

public class Archery{
	public double expectedPoints(int N, int[] ringPoints){
		int totalArea = (N+1) * (N+1);

		double[] probVals = new double[ringPoints.length];
		int odd = 1;
		for(int i=0; i < ringPoints.length; i++){
			probVals[i] = (odd * 1.0)/totalArea;
			odd += 2;
		}

		double retval = 0.0;
		for(int i=0; i < ringPoints.length; i++){
			retval += (probVals[i] * ringPoints[i]);
		}

		return retval;
	}
	

	public static void main(String[] args) {
		Archery ac = new Archery();
		ac.test();
	}

	private void test(){
		int[] N = new int[]{1, 3, 4, 9};
		int[][] ringPoints = new int[][]{
			{10, 0},
			{1, 1, 1, 1},
			{100, 0, 100, 0, 100},
			{69, 50, 79, 16, 52, 71, 17, 96, 56, 32}
		};

		double want[] = new double[]{
			2.5,
			1.0,
			60.0,
			51.96
		};

		for(int i=0; i < N.length; i++){
			double got = expectedPoints(N[i], ringPoints[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(Math.abs(got-want[i]) < 1e-9) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}