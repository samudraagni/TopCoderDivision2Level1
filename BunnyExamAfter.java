public class BunnyExamAfter{
	int getMaximum(String black, String gray, String white){
		int len = black.length();
		int sum = 0;

		for(int i=0; i < len; i++){
			char b = black.charAt(i);
			char g = gray.charAt(i);
			char w = white.charAt(i);

			if(g == w){
				if(g != b && w != b){
					sum += 2;
				}
			}
			else{
				if(!(g == b && w == b)) sum += 1;
			}
		}

		return sum;

		/* 0 indicates different character, 1 indicates same character
		B G W outcome	meaning
		0 0 0 1			all three are different
		0 1 1 2			g and w match and are different from b
		1 0 1 1			b and w match and are different from g
		1 1 0 1			b and g match and are different from w
		1 1 1 0			all three are the same

		The groupings based on outcome
 		B G W outcome
		0 0 0 1

		1 0 1 1
		1 1 0 1

		B G W outcome
		0 1 1 2

		B G W outcome
		1 1 1 0
		*/
	}

	public static void main(String[] args) {
		BunnyExamAfter bea = new BunnyExamAfter();
		bea.test();
	}

	private void test(){
		String black, gray, white;
		
		int want = 0, got = 0;
		int numcases = 5;

		for(int i=0; i < numcases; i++){
			switch (i) {
				case 0:{
					black = new String("ABC");
					gray = new String("ABC");
					white = new String("ABC");

					want = 0;
					got = getMaximum(black, gray, white);
					break;
				}
				case 1:{
					black = new String("A");
					gray = new String("B");
					white = new String("B");

					want = 2;
					got = getMaximum(black, gray, white);
					break;
				}
				case 2:{
					black = new String("ABC");
					gray = new String("PQR");
					white = new String("XYZ");

					want = 3;
					got = getMaximum(black, gray, white);
					break;
				}
				case 3:{
					black = new String("AAAAA");
					gray = new String("AABBB");
					white = new String("BBBAA");

					want = 6;
					got = getMaximum(black, gray, white);
					break;
				}
				case 4:{
					black = new String("TOPCODER");
					gray = new String("TOPBUNNY");
					white = new String("THEHONEY");

					want = 9;
					got = getMaximum(black, gray, white);
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