public class SentenceCapitalizerInator{
	public String fixCaps(String paragraph){
		StringBuilder sb = new StringBuilder();

		int len = paragraph.length();
		char first = Character.toUpperCase(paragraph.charAt(0));
		sb.append(first);

		for(int i=1; i < len; i++){
			if(paragraph.charAt(i) == '.'){
				if(i+1 < len && paragraph.charAt(i+1) == ' '){
					if(i+2 < len){
						sb.append(paragraph.charAt(i));
						sb.append(paragraph.charAt(i+1));

						char cap = Character.toUpperCase(paragraph.charAt(i+2));
						sb.append(cap);
						i = i+2;
					}
				}
				else{
					sb.append(paragraph.charAt(i));
				}
			}
			else{
				sb.append(paragraph.charAt(i));
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		SentenceCapitalizerInator sci = new SentenceCapitalizerInator();
		sci.test();
	}

	private void test(){
		String paragraph;

		String expected = new String();
		String obtained = new String();

		int numcases = 4;
		for(int i=0; i < numcases; i++){
			switch (i) {
				case 0:{
					paragraph = new String("hello programmer. welcome to topcoder.");
					expected = new String("Hello programmer. Welcome to topcoder.");
					obtained = fixCaps(paragraph);
					break;
				}
				case 1:{
					paragraph = new String("one.");
					expected = new String("One.");
					obtained = fixCaps(paragraph);
					break;
				}
				case 2:{
					paragraph = new String("not really. english. qwertyuio. a. xyz.");
					expected = new String("Not really. English. Qwertyuio. A. Xyz.");
					obtained = fixCaps(paragraph);
					break;
				}
				case 3:{
					paragraph = new String("example four. the long fourth example. a. b. c. d.");
					expected = new String("Example four. The long fourth example. A. B. C. D.");
					obtained = fixCaps(paragraph);
					break;
				}
			}
			printResult(i, expected, obtained);
		}
	}

	private void printResult(int casenum, String expected, String obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+casenum);
		if(expected.equals(obtained)) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\nexpected: "+expected+"\nobtained: "+obtained);

		System.out.println(sb.toString()+"\n");
	}
}