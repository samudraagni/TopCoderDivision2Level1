/* https://community.topcoder.com/stat?c=problem_statement&pm=6442 */

public class StringSegment{
	public double average(String s){
		
		int numSegments = 0;
		int sum = 0;

		int len = s.length();

		for(int i=0; i < len; i++){
			int segLen = 0;
			for(int j=i+1; j < len; j++){
				if(s.charAt(i) == s.charAt(j)){
					segLen++;
					i = j;
				}
				else{
					break;
				}
			}
			//add 1 for the first character
			segLen++;
			sum += segLen;
			numSegments++;
		}

		return (sum * 1.0)/numSegments;
	}

	public static void main(String[] args) {
		StringSegment ss = new StringSegment();
		ss.test();
	}

	private void test(){
		String[] s = new String[]{
			"aaabbaaac",
			"aabbccdd",
			"abba"
		};

		double[] want = new double[]{
			2.25,
			2.0,
			1.3333333333333333
		};

		for(int i=0; i < s.length; i++){
			double got = average(s[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(Math.abs(got-want[i]) < 1e-9) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}