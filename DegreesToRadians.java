/* https://community.topcoder.com/stat?c=problem_statement&pm=7410 */

public class DegreesToRadians{
	public 	double convertToRadians(int degrees, int minutes, int seconds){
		double degVal = degrees + minutes/60.0 + seconds/3600.0;
		return degVal * Math.PI / 180.0;
	}

	public static void main(String[] args) {
		DegreesToRadians dtr = new DegreesToRadians();
		dtr.test();
	}

	private void test(){
		int[] degrees = new int[]{0, 180, 359, 23};
		int[] minutes = new int[]{0, 0, 59, 30};
		int[] seconds = new int[]{0, 0, 59, 5};

		double want[] = new double[]{0.0, 3.141592653589793, 6.283180459042776, 0.41017661490272295};

		for(int i=0; i < degrees.length; i++){
			double got = convertToRadians(degrees[i], minutes[i], seconds[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(Math.abs(got - want[i]) < 1e-9) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t want: "+want[i]+"\t got: "+got);

			System.out.println(sb.toString());
		}
	}
}