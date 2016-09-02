/* Tested on Sep 2, 2016. Points: 249.95 */
import java.io.*;

public class WorkingRabbits{
	public double getEfficiency(String[] profit){
		int sum = 0;
		int numPairs = 0;

		for(int i=0; i < profit.length; i++){
			String p = profit[i];
			for(int j=i+1; j < p.length(); j++){
				int val = (p.charAt(j)-'0');
				numPairs++;
				sum += val;
				
			}
		}

		if(numPairs > 0) return (sum * 1.0)/numPairs;
		
		return 0.0;
	}

	public static void main(String[] args) {
		WorkingRabbits wr = new WorkingRabbits();
		wr.test();
	}

	private void test(){
		String[] profit;

		double expected = 0.0;
		double obtained = 0.0;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					profit = new String[]{ "071", "702", "120" };
					expected = 3.3333333333333335;
					obtained = getEfficiency(profit);
					break;
				}
				case 1:{
					profit = new String[]{ "00",  "00" };
					expected = 0.0;
					obtained = getEfficiency(profit);
					break;
				}
				case 2:{
					profit = new String[]{  "0999", "9099", "9909","9990" };
					expected = 9.0;
					obtained = getEfficiency(profit);
					break;
				}
				case 3:{
					profit = new String[]{  "013040", 
											"100010", 
											"300060", 
											"000008", 
											"416000", 
											"000800" };
					expected = 1.5333333333333334;
					obtained = getEfficiency(profit);
					break;
				}
				case 4:{
					profit = new String[]{ 	"06390061", 
											"60960062", 
											"39090270", 
											"96900262", 
											"00000212", 
											"00222026", 
											"66761201", 
											"12022610" };
					expected = 3.2142857142857144;
					obtained = getEfficiency(profit);
					break;
				}
			}
			printResult(i, expected, obtained);
		}
	}

	private void printResult(int testNum, double expected, double obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+testNum);
		if(Math.abs(expected - obtained) <= 1e-9) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t expected: "+expected+"\t obtained: "+obtained);

		System.out.println(sb.toString()+"\n");
	}
}