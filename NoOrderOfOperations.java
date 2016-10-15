/* https://community.topcoder.com/stat?c=problem_statement&pm=2868 */

public class NoOrderOfOperations{
	public int evaluate(String expr){
		int val1 = expr.charAt(0) - '0';

		char op = ' ';
		int val2;

		for(int i=1; i < expr.length(); i++){
			if(i % 2 == 1){
				op = expr.charAt(i);
			}
			else{
				val2 = expr.charAt(i) - '0';
				if(op == '+') val1 = val1 + val2;
				else if(op == '-') val1 = val1 - val2;
				else if(op == '*') val1 = val1 * val2;
			}
		}

		return val1;
	}

	public static void main(String[] args){
		NoOrderOfOperations noop = new NoOrderOfOperations();
		noop.test();
	}

	private void test(){
		String[] expr = new String[]{
			"3+5*7",
			"4-8*9*1",
			"0",
			"1*2*3*4*5*6*7*8*9"
		};

		int[] want = new int[]{
			56,
			-36,
			0,
			362880
		};

		for(int i=0; i < expr.length; i++){
			int got = evaluate(expr[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}