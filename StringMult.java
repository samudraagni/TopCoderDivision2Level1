/* https://community.topcoder.com/stat?c=problem_statement&pm=1046
	Submission was successful for 249.99 points. (for 250)
 */

public class StringMult{
	public 	String times(String sFactor, int iFactor){
		if(iFactor == 0 || sFactor.length() == 0) return "";

		if(iFactor < 0){
			sFactor = new StringBuilder(sFactor).reverse().toString();
			iFactor *= -1;
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i < iFactor; i++){
			sb.append(sFactor);
		}

		return sb.toString();
	}


	public static void main(String[] args) {
		StringMult sm = new StringMult();
		sm.test();
	}

	private void test(){
		String[] sFactor = new String[]{
			"wOw",
			"AbC",
			"Boo",
			"",
			"Racecar"
		};

		int[] iFactor = new int[]{0, -3, 4, 50, -5};
		String[] want = new String[]{
			"",
			"CbACbACbA",
			"BooBooBooBoo",
			"",
			"racecaRracecaRracecaRracecaRracecaR"
		};

		for(int i=0; i < sFactor.length; i++){
			String got = times(sFactor[i], iFactor[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got.equals(want[i])) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}