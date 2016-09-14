/* https://community.topcoder.com/stat?c=problem_statement&pm=12387 */

public class EasyHomework{
	public String determineSign(int[] A){
		int sign = 1;

		for(int a : A){
			if(a == 0) sign *= 0;
			else if (a < 0) sign *= -1;
			else if (a > 0) sign *= 1;
		}

		if(sign == 1) return "POSITIVE";
		else if(sign == -1) return "NEGATIVE";

		return "ZERO";
	}

	public static void main(String[] args) {
		EasyHomework eh = new EasyHomework();
		eh.test();
	}

	private void test(){
		int[][] A = new int[][]{
			{5, 7, 2},
			{-5, 7, 2},
			{5, 7, 2, 0},
			{3, -14, 159, -26},
			{-1000000000},
			{123, -456, 789, -101112, 131415, 161718, 192021, 222324, 252627, 282930, 313233, 343536, 373839, 404142, 434445, 464748, 495051, 525354, 555657}
		};

		String[] want = new String[]{
			"POSITIVE",
			"NEGATIVE",
			"ZERO",
			"POSITIVE",
			"NEGATIVE",
			"POSITIVE"
		};

		for(int i=0; i < A.length; i++){
			String got = determineSign(A[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got.equals(want[i])) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t want: "+want[i]+"\t got: "+got);

			System.out.println(sb.toString());
		}
	}
}