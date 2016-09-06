import java.io.*;

public class AccessLevel{
	public String canAccess(int[] rights, int minPermission){
		String retval = new String();

		for(int right : rights){
			if(right >= minPermission){
				retval += "A";
			}
			else{
				retval += "D";
			}
		}

		return retval;
	}

	public static void main(String[] args) {
		AccessLevel al = new AccessLevel();
		al.test();
	}

	private void test(){
		int[] rights;
		int minPermission;

		String expected = "";
		String obtained = "";

		int numtests = 4;
		for(int i=0; i < numtests; i++){
			switch (i) {
				case 0:{
					rights = new int[]{0,1,2,3,4,5};
					minPermission = 2;
					expected = new String("DDAAAA");
					obtained = canAccess(rights, minPermission);
					break;
				}
				case 1:{
					rights = new int[]{5,3,2,10,0};
					minPermission = 20;
					expected = new String("DDDDD");
					obtained = canAccess(rights, minPermission);
					break;
				}
				case 2:{
					rights = new int[]{};
					minPermission = 20;
					expected = new String("");
					obtained = canAccess(rights, minPermission);
					break;
				}
				case 3:{
					rights = new int[]{34,78,9,52,11,1};
					minPermission = 49;
					expected = new String("DADADD");
					obtained = canAccess(rights, minPermission);
					break;
				}
			}
			printResult(i, expected, obtained);
		}
	}

	private void printResult(int testnum, String expected, String obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case: "+testnum);
		if(expected.equals(obtained)) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t expected: "+expected+"\t obtained: "+obtained);

		System.out.println(sb.toString());
	}
}