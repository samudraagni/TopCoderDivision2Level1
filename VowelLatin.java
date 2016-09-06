import java.io.*;

public class VowelLatin{
	public String translate(String word){
		String cons = new String();
		String vows = new String();

		for(int i=0; i < word.length(); i++){
			String sub = word.substring(i,i+1);
			if("aeiouAEIOU".contains(sub)){
				vows += sub;
			}
			else{
				cons += sub;
			}
		}

		return (cons+vows);
	}

	public static void main(String[] args) {
		VowelLatin vl = new VowelLatin();
		vl.test();
	}

	private void test(){
		String word;

		String expected = new String();
		String obtained = new String();

		int numcases = 4;
		for(int i=0; i < numcases; i++){
			switch (i) {
				case 0:{
					word = new String("XYz");
					expected = new String("XYz");
					obtained = translate(word);
					break;
				}
				case 1:{
					word = new String("application");
					expected = new String("pplctnaiaio");
					obtained = translate(word);
					break;
				}
				case 2:{
					word = new String("qwcvb");
					expected = new String("qwcvb");
					obtained = translate(word);
					break;
				}
				case 3:{
					word = new String("aeioOa");
					expected = new String("aeioOa");
					obtained = translate(word);
					break;
				}
			}
			printResult(i, expected, obtained);
		}
	}

	private void printResult(int caseNum, String expected, String obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+caseNum);
		if(expected.equals(obtained)) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t expected: "+expected+"\t obtained: "+obtained);

		System.out.println(sb.toString());
	}
}