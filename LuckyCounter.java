/* https://community.topcoder.com/stat?c=problem_statement&pm=11229 */

public class LuckyCounter{
	public int countLuckyMoments(String[] moments){

		int count = 0;
		for(String s : moments){
			if(isLucky(s)) count++;
		}
		return count;
	}

	private boolean isLucky(String s){
		char c1 = s.charAt(0);
		char c2 = s.charAt(1);
		char c3 = s.charAt(3);
		char c4 = s.charAt(4);

		//AA:BB
		if(c1 == c2 && c3 == c4) return true;

		//AB:AB
		if(c1 == c3 && c2 == c4) return true;

		//AB:BA
		if(c1 == c4 && c2 == c3) return true;

		return false;
	}

	public static void main(String[] args){
		LuckyCounter lc = new LuckyCounter();
		lc.test();
	}

	private void test(){
		String[][] moments = new String[][]{
			{"12:21", "11:10"},
			{"00:00", "00:59", "23:00"},
			{"12:34"},
			{"12:11", "22:22", "00:01", "03:30", "15:15", "16:00"}
		};

		int[] want = new int[]{1, 1, 0, 3};

		for(int i=0; i < moments.length; i++){
			int got = countLuckyMoments(moments[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+" \t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}
