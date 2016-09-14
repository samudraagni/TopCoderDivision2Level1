/* https://community.topcoder.com/stat?c=problem_statement&pm=13125 */

public class WakingUpEasy{
	public 	int countAlarms(int[] volume, int S){

		int count = 0;
		int i = 0;
		while(S > 0){
			S = S - volume[i];
			count++;
			i++;
			if(i == volume.length) i = 0;
		}

		return count;
	}

	public static void main(String[] args) {
		WakingUpEasy wue = new WakingUpEasy();
		wue.test();
	}

	private void test(){
		int[][] volume = new int[][]{
			{5, 2, 4},
			{5, 2, 4},
			{1},
			{42, 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83, 22, 17, 19, 96, 48, 27, 72, 39, 70, 13, 68, 100, 36, 95, 4, 12, 23, 34, 74, 65, 42, 12, 54, 69}
		};

		int[] S = new int[]{13, 3, 10000, 9999};

		int[] want = new int[]{4, 1, 10000, 203};

		for(int i=0; i < volume.length; i++){
			int got = countAlarms(volume[i], S[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}