/* https://community.topcoder.com/stat?c=problem_statement&pm=11801 */

import java.util.Arrays;

public class RollingDiceDivTwo{
	public int minimumFaces(String[] rolls){
		int[] max = new int[rolls[0].length()];
		Arrays.fill(max, 0);

		for(String roll : rolls){
			char[] carr = roll.toCharArray();
			Arrays.sort(carr);

			for(int i=0; i < carr.length; i++){
				int val = (int)(carr[i]-'0');
				if(val > max[i]){
					max[i] = val;
				}
			}
		}

		int retval = 0;
		for(int m : max){
			retval += m;
		}

		return retval;
	}
	

	public static void main(String[] args) {
		RollingDiceDivTwo rdt = new RollingDiceDivTwo();
		rdt.test();
	}

	private void test(){
		String[][] rolls = new String[][]{
			{"137", "364", "115", "724"},
			{"1112", "1111", "1211", "1111"},
			{"24412", "56316", "66666", "45625"},
			{"931", "821", "156", "512", "129", "358", "555"},
			{"3", "7", "4", "2", "4"},
			{"281868247265686571829977999522", "611464285871136563343229916655", "716739845311113736768779647392", "779122814312329463718383927626",
			"571573431548647653632439431183", "547362375338962625957869719518", "539263489892486347713288936885", "417131347396232733384379841536"}
		};

		int[] want = new int[]{14, 5, 30, 19, 7, 176};

		for(int i=0; i < rolls.length; i++){
			int got = minimumFaces(rolls[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}