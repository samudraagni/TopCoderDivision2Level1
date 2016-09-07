import java.io.*;

public class ForgetfulAddition{
	public int minNumber(String expression){
		int len = expression.length();
		int min = Integer.MAX_VALUE;

		for(int i=0; i < len-1; i++){
			String fp = expression.substring(0,i+1);/* first part */
			String lp = expression.substring(i+1);/* last part */

			int fi = Integer.parseInt(fp);
			int li = Integer.parseInt(lp);

			int sum = fi + li;
			if(sum < min) min = sum;
		}

		return min;
	}

	public static void main(String[] args) {
		ForgetfulAddition fa = new ForgetfulAddition();
		fa.test();
	}

	private void test(){
		String expression;

		int want = 0, got = 0;
		int numcases = 5;
		for(int i=0; i < numcases; i++){
			switch (i) {
				case 0:{
					expression = new String("22");
					want = 4;
					got = minNumber(expression);
					break;
				}
				case 1:{
					expression = new String("123");
					want = 15;
					got = minNumber(expression);
					break;
				}
				case 2:{
					expression = new String("1289");
					want = 101;
					got = minNumber(expression);
					break;
				}
				case 3:{
					expression = new String("31415926");
					want = 9067;
					got = minNumber(expression);
					break;
				}
				case 4:{
					expression = new String("98765");
					want = 863;
					got = minNumber(expression);
					break;
				}
			}
			printResult(i, want, got);
		}
	}

	private void printResult(int casenum, int want, int got){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+casenum);
		if(want == got) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t want: "+want+"\t got: "+got);

		System.out.println(sb.toString());
	}
}