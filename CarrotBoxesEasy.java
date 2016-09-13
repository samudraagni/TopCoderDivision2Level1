/* https://community.topcoder.com/stat?c=problem_statement&pm=11307 */
import java.io.*;
import java.util.*;

public class CarrotBoxesEasy{
	public int theIndex(int[] carrots, int K){
		/* copy and sort the array in descending order */
		int[] cc = new int[carrots.length+1];
		for(int i=0; i < carrots.length; i++){
			cc[i] = -carrots[i];
		}
		cc[carrots.length] = -0;
		Arrays.sort(cc);
		/* now change sign :P */
		for(int i=0; i < cc.length; i++){
			cc[i] = -1 * cc[i];
		}

		int count = 1;
		int index = 0;

		for(int i=0; i < cc.length-1; i++){
			int reduction = (cc[i] - cc[i+1]) * count;
			K = K - reduction;

			if(K < 0){
				K = K + reduction;
				index = K % count;

				if(index == 0) index = carrots.length;
				
				else index = index-1;

				break;
			}
			else if(K == 0){
				index = (count == 1)?count : count -1;
				break;
			}

			count++;
		}

		return index;
	}

	public static void main(String[] args) {
		CarrotBoxesEasy cbe = new CarrotBoxesEasy();
		cbe.test();
	}

	private void test(){
		int[][] carrots = new int[][]{
			{5, 8},
			{5, 8},
			{4, 9, 5},
			{13, 75, 24, 55},
			{14, 36, 52, 86, 27, 97, 3, 67}
		};

		int[] K = new int[]{3, 4, 18, 140, 300};
		int[] want = new int[]{1, 0, 2, 0, 4};

		for(int i=0; i < carrots.length; i++){
			int got = theIndex(carrots[i], K[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\t want: "+want[i]+"\t got: "+got);
			
			System.out.println(sb.toString());
		}
	}
}