/* https://community.topcoder.com/stat?c=problem_statement&pm=3091 
	250/250
*/

public class LeapAge{
	public int getAge(int year, int born){
		int count = 0;
		for(int i=born+1; i <= year; i++){
			if(isLeapYear(i)) count++;
		}
		return count;
	}


	private boolean isLeapYear(int val){
		boolean isLeap = (val % 4 == 0);
		isLeap = isLeap && (val % 100 != 0);
		isLeap = isLeap || (val % 400 == 0);
		return isLeap;
	}

	public static void main(String[] args){
		LeapAge la = new LeapAge();
		la.test();
	}

	private void test(){
		int[] year = new int[]{2004, 10000, 2007, 1981, 1984, 9700};
		int[] born = new int[]{1980, 1582, 1981, 1980, 1983, 5795};
		int[] want = new int[]{6, 2042, 6, 0, 1, 947};

		for(int i=0; i < year.length; i++){
			int got = getAge(year[i], born[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}