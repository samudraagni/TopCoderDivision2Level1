/* https://community.topcoder.com/stat?c=problem_statement&pm=13940 */

public class BearCheats{
	public String eyesight(int A, int B){
		String sA = Integer.toString(A);
		String sB = Integer.toString(B);

		int numDiff = 0;
		for(int i=0; i < sA.length(); i++){
			if(sA.charAt(i) != sB.charAt(i)){
				numDiff++;
			}
		}

		if(numDiff <= 1) return "happy";

		return "glasses";
	}

	public static void main(String[] args) {
		BearCheats bc = new BearCheats();
		bc.test();
	}

	private void test(){
		int[] A = new int[]{8072, 508, 854000, 1, 385900};
		int[] B = new int[]{3072, 540, 854000, 6, 123000};

		String[] want = new String[]{
			"happy",
			"glasses",
			"happy",
			"happy",
			"glasses"
		};

		for(int i=0; i < A.length; i++){
			String got = eyesight(A[i], B[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got.equals(want[i])) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}