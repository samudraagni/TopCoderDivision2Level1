/* https://community.topcoder.com/stat?c=problem_statement&pm=14295 */

public class PriorityQueue{
	int findAnnoyance(String S, int[] a){

		int displeasure = 0;

		for(int i=0; i < S.length(); i++){
			char c = S.charAt(i);
			if(c == 'b'){
				for(int j=0; j < i; j++){
					displeasure += a[j];
				}
			}
		}

		return displeasure;
	}

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.test();
	}

	private void test(){
		String[] S = new String[]{
			"bbbbb",
			"bee",
			"ebbe",
			"bbeebeebeeeebbb"
		};

		int[][] a = new int[][]{
			{1,1,1,1,1},
			{50,40,30},
			{5,2,11,1},
			{58,517,301,524,79,375,641,152,810,778,222,342,911,313,336}
		};

		int[] want = new int[]{10, 0, 12, 20485};
		for(int i=0; i < S.length; i++){
			int got = findAnnoyance(S[i], a[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want "+want[i]);

			System.out.println(sb.toString());
		}
	}
}