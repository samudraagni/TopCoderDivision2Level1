/* https://community.topcoder.com/stat?c=problem_statement&pm=8730 */

public class VariableSpeedLimit{
	public 	double journeyTime(int journeyLength, int[] speedLimit){

		int curLen = 0;
		int count = 0;
		int i = 0;
		while(curLen < journeyLength){
			curLen += speedLimit[i];

			//System.out.println(curLen+" "+i+" "+speedLimit[i]+" "+journeyLength);
			if(curLen <= journeyLength) count++;

			i++;
			if(i == speedLimit.length){
				i = 0;
			}
		}
		int diff = curLen - journeyLength;

		int denom = (i-1)<0? 0 : (i-1);
		double exact = (diff > 0)?(1.0 - (double)(diff)/speedLimit[denom]):0;

		//System.out.println(diff+" "+exact+" count: "+count);
		return (double)(count+exact);
	}

	public static void main(String[] args){
		VariableSpeedLimit vsl = new VariableSpeedLimit();
		vsl.test();
	}

	private void test(){
		int[] journeyLength = new int[]{
			100,
			100,
			1000,
			2058,
			17216,
			9839
		};

		int[][] speedLimit = new int[][]{
			{50},
			{50,25},
			{50,40,30,40,50},
			{80,43,57,23,28,45,60,75,73,80},
			{26,30,62,55,51,56,58,4,60,23,31},
			{45,90,13,4,81,50,81,10,64,86,69}
		};

		double want[] = new double[]{
			2.0,
			2.5,
			24.0,
			37.4,
			415.03333333333336,
			182.8395061728395
		};

		for(int i=0; i < journeyLength.length; i++){
			double got = journeyTime(journeyLength[i], speedLimit[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(Math.abs(got-want[i]) <= 1E-9) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\nwant:\t"+want[i]+"\ngot:\t"+got);

			System.out.println(sb.toString()+"\n");
		}
	}
}