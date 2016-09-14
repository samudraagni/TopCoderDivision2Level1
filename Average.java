/* https://community.topcoder.com/stat?c=problem_statement&pm=818 */

public class Average{
	public int belowAvg(int[] math, int[] verbal){
		int[] comp = new int[math.length];

		int compSum = 0;
		for(int i=0; i < math.length; i++){
			comp[i] = math[i] + verbal[i];
			compSum += comp[i];
		}

		double compAvg = (compSum * 1.0)/math.length;
		int count = 0;

		for(int c : comp){
			if(c < compAvg) count++;
		}

		return count;
	}

	public static void main(String[] args) {
		Average av = new Average();
		av.test();
	}

	private void test(){
		int[][] math = new int[][]{
			{200,250,700,700},
			{500,400},
			{293},
			{400,400,400,400,400,400,401}
		};

		int[][] verbal = new int[][]{
			{400,400,400,400},
			{300,400},
			{799},
			{400,400,400,400,400,400,400}
		};

		int[] want = new int[]{2, 0, 0, 6};

		for(int i=0; i < math.length; i++){
			int got = belowAvg(math[i], verbal[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(want[i] == got) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\tWant: "+want[i]+"\tgot: "+got);

			System.out.println(sb.toString());
		}
	}
}