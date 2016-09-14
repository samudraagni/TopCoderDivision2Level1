/* https://community.topcoder.com/stat?c=problem_statement&pm=11194 */

import java.io.*;

public class TheBoredomDivTwo{
	public 	int find(int n, int m, int j, int b){
		boolean[] bored = new boolean[n+m+1];//1-based

		int boredCount = n;

		int i = 1;
		for(; i <= n; i++){
			bored[i] = true;
		}
		for(; i <= n+m; i++){
			bored[i] = false;
		}

		if(!bored[j]) {
			bored[j] = true;
			boredCount++;
		}
		
		if(!bored[b]){
			bored[b] = true;
			boredCount++;
		}

		return boredCount;
	}

	public static void main(String[] args) {
		TheBoredomDivTwo tbdt = new TheBoredomDivTwo();
		tbdt.test();
	}

	private void test(){
		int[] n = new int[]{1, 2, 1, 4};
		int[] m = new int[]{1, 1, 2, 7};
		int[] j = new int[]{1, 1, 3, 7};
		int[] b = new int[]{2, 2, 2, 4};

		int[] want = new int[]{2, 2, 3, 5};
		for(int i=0; i < n.length; i++){

			int got = find(n[i], m[i], j[i], b[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\t got "+got+"\t want "+want[i]);

			System.out.println(sb.toString());
		}
	}
}