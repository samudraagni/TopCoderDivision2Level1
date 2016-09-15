/* https://community.topcoder.com/stat?c=problem_statement&pm=5982 */

import java.io.*;

public class SpeedTyper{
	public String lettersToPractice(String letters, int[] times){
		int[] actualTimes = new int[times.length];
		
		actualTimes[0] = times[0];
		int sum = actualTimes[0];
		for(int i=1; i < times.length; i++){
			actualTimes[i] = times[i]-times[i-1];
			sum += actualTimes[i];
		}

		int avg = sum / times.length;
		
		String ret = new String();
		for(int i=0; i < actualTimes.length; i++){
			if(actualTimes[i] > avg){
				ret += letters.substring(i,i+1);
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		SpeedTyper st = new SpeedTyper();
		st.test();
	}

	private void test(){
		String[] letters = new String[]{
			"dcab",
			"keyboard",
			"rewq",
			"abc"
		};

		int[][] times = new int[][]{
			{250, 300, 400, 800},
			{100,200,300,500,600,800,900,1200},
			{500, 1000, 1500, 4000},
			{2000, 4000, 6000}
		};

		String[] want = new String[]{
			"db",
			"bad",
			"q",
			""
		};

		for(int i=0; i < letters.length; i++){
			String got = lettersToPractice(letters[i], times[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got.equals(want[i])) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got " +got+" \t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}