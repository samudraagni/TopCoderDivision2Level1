/* https://community.topcoder.com/stat?c=problem_statement&pm=8304 */

public class TwoRotationCypher{
	public String encrypt(int firstSize, int firstRotate, int secondRotate, String message){

		String firstGroup = new String();
		for(int i=0; i < firstSize; i++){
			char c = (char)('a' + i);
			firstGroup += String.valueOf(c);
		}

		String secondGroup = new String();
		for(int i = firstSize; i < 26; i++){
			char c = (char)('a' + i);
			secondGroup += String.valueOf(c);
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i < message.length(); i++){
			char c = message.charAt(i);
			if(c != ' '){
				int group = (c - 'a') < firstSize? 1 : 2;

				if(group == 1){
					int charPos = firstGroup.indexOf(c);
					int idx = (charPos + firstRotate) % firstGroup.length();
					char sub = firstGroup.charAt(idx);
		
					sb.append(sub);
				}
				else{
					int charPos = secondGroup.indexOf(c);
					int idx = (charPos + secondRotate) % secondGroup.length();
					char sub = secondGroup.charAt(idx);
		
					sb.append(sub);
				}
			}
			else{
				sb.append(c);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		TwoRotationCypher trc = new TwoRotationCypher();
		trc.test();
	}

	private void test(){
		int[] firstSize = new int[]{13, 13, 9 , 17, 3};
		int[] firstRotate = new int[]{0, 7, 0, 9, 1};
		int[] secondRotate = new int[]{0, 0, 16, 5, 2};
		String[] message = new String[]{
			"this string will not change at all",
			"only the letters a to m in this string change",
			"j to z will change here",
			"the quick brown fox jumped over the lazy dog",
			"  watch   out for strange  spacing "
		};

		String[] want = new String[]{
			"this string will not change at all",
			"onfy tbl flttlrs h to g cn tbcs strcna jbhnal",
			"z sn y vikk chamge heqe",
			"yqn izalc kwgsf ogt bzehnm grnw yqn djvu mgp",
			"  ybvaj   qwv hqt uvtbpig  urbakpi "
		};

		for(int i=0; i < firstSize.length; i++){
			String got = encrypt(firstSize[i], firstRotate[i], secondRotate[i], message[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got.equals(want[i])) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\n got: "+got+"\n want: "+want[i]+"\n");
			
			System.out.println(sb.toString());
		}
	}
}