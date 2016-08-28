import java.io.*;
import java.util.*;

public class MiddleCode{
	public String encode(String s){
		String val = new String();

		int len = s.length();
		while(len > 0){
			int mid = (int)Math.floor(len/2);
			
			int copyIndex;
			if(len % 2 == 1){
				val += s.substring(mid, mid+1);
				copyIndex = mid;
			}
			else{
				mid = mid-1;
				if(s.substring(mid,mid+1).compareTo(s.substring(mid+1, mid+2)) < 0){
					val += s.substring(mid,mid+1);
					copyIndex = mid;
				}
				else{
					val += s.substring(mid+1, mid+2);
					copyIndex = mid+1;
				}
			}

			String temp = s.substring(0, copyIndex);
			temp += s.substring(copyIndex+1);
			s = new String(temp);

			len = s.length();
		}

		return val;
	}

	public static void main(String[] args) {
		MiddleCode mc = new MiddleCode();
		mc.test();
	}

	private void test(){
		String s;
		String expected;
		String obtained;

		int numTests = 5;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					s = new String("word");
					expected = new String("ordw");
					obtained = encode(s);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					s = new String("aaaaa");
					expected = new String("aaaaa");
					obtained = encode(s);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					s = new String("abacaba");
					expected = new String("caabbaa");
					obtained = encode(s);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					s = new String("shjegr");
					expected = new String("ejghrs");
					obtained = encode(s);
					printResult(i, expected, obtained);
					break;
				}
				case 4:{
					s = new String("adafaaaadafawafwfasdaa");
					expected = new String("afawadafawafaafsadadaa");
					obtained = encode(s);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, String expected, String obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+testNum);
		if(expected.equals(obtained)) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\t expected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}