/* https://community.topcoder.com/stat?c=problem_statement&pm=7406
	249.99/250
 */

public class Palindromize2{
	public String minChanges(String s){
		int len = s.length();
		char[] vals = new char[len];

		for(int i=0, j=len-1; i < len && j >= 0 && i <= j; i++, j--){
			char sc = s.charAt(i);
			char ec = s.charAt(j);

			if(sc < ec){
				ec = sc;
			}
			else if(sc > ec){
				sc = ec;
			}

			vals[i] = sc;
			vals[j] = ec;
		}

		return new String(vals);
	}


	public static void main(String[] args){
		Palindromize2 p2 = new Palindromize2();
		p2.test();
	}

	private void test(){
		String[] s = new String[]{
			"ameba",
			"cigartragic",
			"abcdef",
			"cxbpaxz"
		};

		String[] want = new String[]{
			"abeba",
			"cigartragic",
			"abccba",
			"cxapaxc"
		};

		for(int i=0; i < s.length; i++){
			String got = minChanges(s[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got.equals(want[i])) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}