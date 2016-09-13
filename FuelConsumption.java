/* https://community.topcoder.com/stat?c=problem_statement&pm=2980 */
import java.io.*;

public class FuelConsumption{
	public double maximalDistance(int[] velocities, int[] consumptions, int fuel){

		double max = Double.MIN_VALUE;
		for(int i=0; i < velocities.length; i++){
			double val = ((fuel * 1.0)/ consumptions[i]) * velocities[i];

			if(val > max){
				max = val;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		FuelConsumption fc = new FuelConsumption();
		fc.test();
	}

	private void test(){
		int[][] velocities = new int[][]{
			{100}, 
			{70, 80, 90, 100, 60, 110},
			{250, 240, 230, 220, 210, 211},
			{5, 10, 20, 40, 80},
			{5, 10, 20, 40, 80, 160},
			{240, 195, 130, 133, 15, 160, 111, 206, 72, 149,146, 115, 235, 183, 102, 96, 163, 61, 196, 52, 87, 139, 33, 7, 90, 67, 118, 227, 197, 114}		
		};

		int[][] consumptions = new int[][]{
			{10000},
			{4000, 4000, 4000, 4000, 4000, 4000},
			{5000, 4500, 4000, 3500, 3000, 3000},
			{1000, 2500, 6250, 9000, 18000},
			{1000, 2500, 6250, 8000, 9500, 20000},
			{14837, 2981, 17292, 18591, 4832, 7461, 17991, 18369, 18291, 9400, 15179, 3317, 2595, 2441, 6936, 8028, 14973, 18981, 12503, 7816, 2883, 6385, 6230, 18157, 16567, 9310, 2866, 4687, 14171, 4477}
		};

		int[] fuels = new int[]{10000, 40000, 50000, 47832, 47832, 31710};

		double[] want = new double[]{100.0, 1100.0, 3516.6666666666665, 239.16, 402.79578947368424, 2871.6184971098264};

		for(int i=0; i < velocities.length; i++){
			double got = maximalDistance(velocities[i], consumptions[i], fuels[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(Math.abs(got - want[i]) < 1e-9) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\t want: "+want[i]+"\t got: "+got);

			System.out.println(sb.toString());
		}
	}
}