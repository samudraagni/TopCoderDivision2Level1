/* https://community.topcoder.com/stat?c=problem_statement&pm=10294 */

import java.io.*;

public class SkiFriction{
	public int bestPosition(String skiFriction, String pathFriction){

		if(skiFriction.length() >= pathFriction.length()) return 0;

		int skl = skiFriction.length();
		int pfl = pathFriction.length();

		int retval = 0;

		for(int i=0; i < pfl - skl; i++){
			int max = 0;
			for(int j=0; j < skl; j++){
				int sv = skiFriction.charAt(j)-'0';
				int pv = pathFriction.charAt(i+j)-'0';

				if(pv + sv > max){
					max = pv + sv;
				}
			}
			retval += max;
		}

		return retval;
	}

	public static void main(String[] args) {
		SkiFriction sf = new SkiFriction();
		sf.test();
	}

	private void test(){
		String[] skiFriction = new String[]{
			"45",
			"6",
			"6723",
			"623883347715596655"
		};

		String[] pathFriction = new String[]{
			"15196",
			"65",
			"562516639",
			"724951246328811474"
		};

		int[] want = new int[]{
			33,
			12,
			61,
			0
		};

		for(int i=0; i < skiFriction.length; i++){
			int got = bestPosition(skiFriction[i], pathFriction[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\tGot: "+got+" \tWant: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}