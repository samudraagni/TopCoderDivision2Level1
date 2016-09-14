/* https://community.topcoder.com/stat?c=problem_statement&pm=10814 */

import java.io.*;

public class Cryptography{
	public long encrypt(int[] numbers){
		int min = Integer.MAX_VALUE;

		long prod = 1l;
		for(int n : numbers){
			if(n < min) min = n;
			prod *= n;
		}

		prod = prod/min;

		min = min+1;

		prod = prod * min;

		return prod;
	}

	public static void main(String[] args) {
		Cryptography cg = new Cryptography();
		cg.test();
	}

	private void test(){
		int[][] numbers = new int[][]{
			{1,2,3},
			{1,3,2,1,1,3},
			{1000,999,998,997,996,995},
			{1,1,1,1}
		};

		long[] want = new long[]{
			12,
			36,
			986074810223904000l,
			2
		};

		for(int i=0; i < numbers.length; i++){
			long got = encrypt(numbers[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+" \t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}
