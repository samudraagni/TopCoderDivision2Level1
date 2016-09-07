import java.io.*;

public class CssPropertyConverter{
	public String getCamelized(String cssPropertyName){
		int len = cssPropertyName.length();
		StringBuilder retval = new StringBuilder();

		for(int i=0; i < len; i++){
			if(cssPropertyName.charAt(i) == '-'){
				retval.append(Character.toUpperCase(cssPropertyName.charAt(i+1)));
				i++;
			}
			else{
				retval.append(cssPropertyName.charAt(i));
			}
		}

		return retval.toString();
	}

	public static void main(String[] args) {
		CssPropertyConverter cpc = new CssPropertyConverter();
		cpc.test();
	}

	private void test(){
		String cssPropertyName;

		String want = new String();
		String got = new String();

		int numcases = 3;
		for(int i=0; i < numcases; i++){
			switch (i) {
				case 0:{
					cssPropertyName = new String("z-index");
					want = new String("zIndex");
					got = getCamelized(cssPropertyName);
					break;
				}
				case 1:{
					cssPropertyName = new String("border-collapse");
					want = new String("borderCollapse");
					got = getCamelized(cssPropertyName);
					break;
				}
				case 2:{
					cssPropertyName = new String("top-border-width");
					want = new String("topBorderWidth");
					got = getCamelized(cssPropertyName);
					break;
				}
			}
			printResult(i, want, got);
		}
	}

	private void printResult(int casenum, String want, String got){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+casenum);
		if(want.equals(got)) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t want: "+want+"\t got: "+got);

		System.out.println(sb.toString());
	}
}