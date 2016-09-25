/* https://community.topcoder.com/stat?c=problem_statement&pm=11127 */

import java.util.HashMap;

public class DigitHoles{

	private HashMap<String, Integer> map;
	public DigitHoles(){
		this.map = new HashMap<String, Integer>();

		/* zero holes */
		map.put("1", 0);
		map.put("2", 0);
		map.put("3", 0);
		map.put("5", 0);
		map.put("7", 0);

		/* one hole */
		map.put("0", 1);
		map.put("4", 1);
		map.put("6", 1);
		map.put("9", 1);
		
		/* two holes */
		map.put("8", 2);
	}

	public int numHoles(int number){

		int total = 0;
		String num = Integer.toString(number);

		for(int i=0; i < num.length(); i++){
			String s = num.substring(i,i+1);
			total += map.get(s);
		}

		return total;
	}

	public static void main(String[] args) {
		DigitHoles dh = new DigitHoles();
		dh.test();
	}

	private void test(){
		int[] number = new int[]{42, 669, 688, 123, 456, 789};
		int[] want = new int[]{1, 3, 5, 0, 2, 3};

		for(int i=0; i < number.length; i++){
			int got = numHoles(number[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want:"+want[i]);

			System.out.println(sb.toString());
		}
	}
}