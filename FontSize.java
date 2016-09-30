/* https://community.topcoder.com/stat?c=problem_statement&pm=2000 */

public class FontSize{
	public int getPixelWidth(String sentence, int[] uppercase, int[] lowercase){
		int count = 0;

		for(int i=0; i < sentence.length(); i++){

			char c = sentence.charAt(i);

			if(c == ' ') {
				count += 3;
			}
			else{
				int idx = c-'A';
				if(idx <= 26){
					count += uppercase[idx];
				}
				else{
					idx  = c - 'a';
					count += lowercase[idx];
				}
			}

			if(i < sentence.length()-1) count++;
		}

		return count;
	}

	public static void main(String[] args){
		FontSize fs = new FontSize();
		fs.test();
	}

	private void test(){
		String[] sentence = new String[]{
			"Dead Beef",
			"Hello World",
			"Hello World",
			"ThE qUiCk BrOwN fOx JuMpEd OvEr ThE lAzY dOg",
			"two  spaces"
		};

		int[][] uppercase = new int[][]{
			{6,6,6,7,7,7,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{7,8,8,8,7,8,8,8,7,8,8,8,8,8,7,8,8,8,8,8,7,8,8,8,8,8},
			{7,7,7,7,7,7,7,8,7,7,7,7,7,7,7,7,7,7,7,7,7,7,9,7,7,7},
			{36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9}
		};

		int[][] lowercase = new int[][]{
			{5,5,5,4,4,4,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{5,6,6,6,5,6,6,6,5,6,6,6,6,6,5,6,6,6,6,6,5,6,6,6,6,6},
			{5,5,5,6,6,5,5,5,5,5,5,1,5,5,6,5,5,6,5,5,5,5,5,5,5,5},
			{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26},
			{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
		};

		int[] want = new int[]{49, 74, 63, 778, 43};

		for(int i=0; i < sentence.length; i++){
			int got = getPixelWidth(sentence[i], uppercase[i], lowercase[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}