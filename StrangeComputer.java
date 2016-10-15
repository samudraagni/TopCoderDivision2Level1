/* https://community.topcoder.com/stat?c=problem_statement&pm=10537 */

public class StrangeComputer{
	public int setMemory(String mem){
		int flips = 0;

		char prev = mem.charAt(0);
		for(int i=1; i < mem.length(); i++){
			char cur = mem.charAt(i);
			if(prev != cur){
				flips++;
			}
			prev = cur;
		}

		if(mem.charAt(0) == '1') flips++;

		return flips;
	}

	public static void main(String[] args){
		StrangeComputer sc = new StrangeComputer();
		sc.test();
	}

	private void test(){
		String[] mem = new String[]{
			"0011",
			"000",
			"0100",
			"111000111"
		};

		int[] want = new int[]{
			1, 
			0, 
			2, 
			3
		};

		for(int i=0; i < mem.length; i++){
			int got = setMemory(mem[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got:\t"+got+"\t want:\t"+want[i]);

			System.out.println(sb.toString());
		}
	}
}