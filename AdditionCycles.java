/* https://community.topcoder.com/stat?c=problem_statement&pm=6736 */

public class AdditionCycles{
	public int cycleLength(int n){

		int newnum = -1;
		int count = 0;
		int temp = n;

		while(newnum != n){

			count++;

			int prevFD = 0;
			int prevSD = 0;

			if(temp >= 10) prevFD = temp/10;
			prevSD = temp % 10;

			int sum = prevFD + prevSD;

			int sumFD = 0;
			int sumSD = 0;

			if(sum >= 10) sumFD = sum/10;
			sumSD = sum % 10;

			newnum = prevSD*10 + sumSD;

			temp = newnum;
		}

		return count;
	}

	public  static void main(String[] args){
		AdditionCycles ac = new AdditionCycles();
		ac.test();
	}

	private void test(){
		int[] n = new int[]{26, 55, 0, 71};
		int[] want = new int[]{4, 3, 1, 12};

		for(int i=0; i < n.length; i++){
			int got = cycleLength(n[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}