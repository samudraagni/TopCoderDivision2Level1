import java.io.*;
import java.util.*;

public class TopFox{
	public int possibleHandles(String familyName, String givenName){
		HashSet<String> handles = new HashSet<String>();

		for(int i=1; i <= familyName.length(); i++){
			String f = familyName.substring(0,i);
			for(int j= 1; j <= givenName.length(); j++){
				String g = givenName.substring(0, j);
				String h = f + g;

				handles.add(h);
			}
		}

		Iterator it = handles.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"\t");
		}
		System.out.println();
		
		return handles.size();
	}

	public static void main(String[] args) {
		TopFox tf = new TopFox();
		tf.test();
	}

	private void test(){
		String familyName;
		String givenName;

		int expected = 0;
		int obtained = 0;

		int numTests = 6;
		for(int i=0; i < numTests; i++){
			switch(i){
				case 0:{
					familyName = new String("ab");
					givenName = new String("cd");
					expected = 4;
					obtained = possibleHandles(familyName, givenName);
					break;
				}
				case 1:{
					familyName = new String("abb");
					givenName = new String("bbc");
					expected = 7;
					obtained = possibleHandles(familyName, givenName);
					break;
				}
				case 2:{
					familyName = new String("fox");
					givenName = new String("ciel");
					expected = 12;
					obtained = possibleHandles(familyName, givenName);
					break;
				}
				case 3:{
					familyName = new String("abbbb");
					givenName = new String("bbbbbbbc");
					expected = 16;
					obtained = possibleHandles(familyName, givenName);
					break;
				}
				case 4:{
					familyName = new String("abxy");
					givenName = new String("xyxyxc");
					expected = 21;
					obtained = possibleHandles(familyName, givenName);
					break;
				}
				case 5:{
					familyName = new String("ababababab");
					givenName = new String("bababababa");
					expected = 68;
					obtained = possibleHandles(familyName, givenName);
					break;
				}
			}
			printResult(i, expected, obtained);
		}
	}

	private void printResult(int testNum, int expected, int obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+testNum);
		if(expected == obtained) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t expected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}