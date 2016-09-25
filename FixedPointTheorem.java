/* https://community.topcoder.com/stat?c=problem_statement&pm=1765 

	Successful: 249.99/250

*/

import java.util.TreeSet;

public class FixedPointTheorem{
	public double cycleRange(double R){
		/* F(X)=R*X*(1-X), X = 0.25 */

		double X = 0.25;
		for(int i=0; i < 200000; i++){
			X = R * X * (1.0 - X);
		}

		TreeSet<Double> set = new TreeSet<Double>();
		for(int i=0; i < 1000; i++){
			X = R * X * (1.0 - X);
			set.add(X);
		}

		double min = set.first();
		double max = set.last();

		return (max - min);
	}


	public static void main(String[] args) {
		FixedPointTheorem fpt = new FixedPointTheorem();
		fpt.test();
	}

	private void test(){
		double[] R = new double[]{0.1, 3.05, 3.4499, 3.55, 3.565, 3.5689, 3.00005};
		double[] want = new double[]{
			0.0,
			0.14754098360655865,
			0.4175631735867292,
			0.5325704489850351,
			0.5454276003030636,
			0.5489996297493569,
			0.004713996108955176
		};

		for(int i=0; i < R.length; i++){
			double got = cycleRange(R[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(Math.abs(got - want[i]) < 1e-9) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}