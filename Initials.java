/* https://community.topcoder.com/stat?c=problem_statement&pm=14389 

Successful for 249.94/250.
*/

public class Initials{
	public 	String getInitials(String name){
		String[] parts = name.split(" ");
		String ret = parts[0].substring(0,1);

		for(int i=1; i < parts.length; i++){
			ret += parts[i].substring(0,1);
		}

		return ret;
	}

	public static void main(String[] args) {
		Initials in = new Initials();
		in.test();
	}

	private void test(){
		String[] name = new String[]{
			"john fitzgerald kennedy",
			"single",
			"looks good to me",
			"single round match",
			"a aa aaa aa a bbb bb b bb bbb"
		};

		String[] want = new String[]{
			"jfk",
			"s",
			"lgtm",
			"srm",
			"aaaaabbbbb"
		};

		for(int i=0; i < name.length; i++){
			String got = getInitials(name[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got.equals(want[i])) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}