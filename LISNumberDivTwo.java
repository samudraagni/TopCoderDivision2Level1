/* https://community.topcoder.com/stat?c=problem_statement&pm=12446 */

public class LISNumberDivTwo{
	public 	int calculate(int[] seq){
		int count = 0;
		int addToSeq = 0;

		for(int i=0; i < seq.length; i++){
			int j = i+1;
			while(i < seq.length && j < seq.length && seq[i] < seq[j]){
				i++;
				j++;
			}
			count++;
		}

		return count;
	}	

	public static void main(String[] args) {
		LISNumberDivTwo lnd = new LISNumberDivTwo();
		lnd.test();
	}

	private void test(){
		int[][] seq = new int[][]{
			{1, 4, 4, 2, 6, 3},
			{5, 8, 9, 12, 16, 32, 50},
			{1, 1, 9, 9, 2, 2, 3, 3},
			{50, 40, 30, 20, 10},
			{42}
		};

		int[] want = new int[]{4, 1, 6, 5, 1};

		for(int i=0; i < seq.length; i++){
			int got = calculate(seq[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\tgot: "+got+"\twant: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}