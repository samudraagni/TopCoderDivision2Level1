/* https://community.topcoder.com/stat?c=problem_statement&pm=11056 */

public class P8XMatrixTransformation{
	public String solve(String[] original, String[] target){
		int[] count = new int[2];
		count[0] = 0;
		count[1] = 0;

		for(String o : original){
			for(int i=0; i < o.length(); i++){
				count[o.charAt(i)-'0']++;
			}
		}

		for(String t : target){
			for(int i=0; i < t.length(); i++){
				count[t.charAt(i)-'0']--;
			}
		}

		if(count[0] == 0 && count[1] == 0) return "YES";

		return "NO";
	}

	public static void main(String[] args) {
		P8XMatrixTransformation pmt = new P8XMatrixTransformation();
		pmt.test();
	}

	private void test(){
		String[][] original = new String[][]{
			{"01","11"},
			{"0111","0011"},
			{"0"},
			{"1111", "1111","0000","0000"},
			{"0110","1001","0110"},
			{"0000","1111","0000"}
		};

		String[][] target = new String[][]{
			{"11","10"},
			{"1011","1100"},
			{"1"},
			{"1111","1111","0000","0000"},
			{"1111","0110","0000"},
			{"1111","0000","1111"}
		};

		String[] want = new String[]{
			"YES", "YES", "NO", "YES", "YES", "NO"
		};

		for(int i=0; i < original.length; i++){
			String got = solve(original[i], target[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got.equals(want[i])) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+" \t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}