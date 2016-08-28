import java.io.*;
import java.util.*;

public class WhichDay{
	public String getDay(String[] notOnThisDay){
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		map = fillMap(map);

		for(String nd : notOnThisDay){
			if(map.get(nd) == false) map.put(nd, true);
		}

		Set<String> days = map.keySet();
		String ret = new String();
		for(String day : days){
			if(map.get(day) == false){
				ret = new String(day);	
			} 
		}
		return ret;
	}

	private HashMap<String, Boolean> fillMap(HashMap<String, Boolean> map){
		map.put("Sunday", false);
		map.put("Monday", false);
		map.put("Tuesday", false);
		map.put("Wednesday", false);
		map.put("Thursday", false);
		map.put("Friday", false);
		map.put("Saturday",false);
		return map;
	}

	public static void main(String[] args) {
		WhichDay wd = new WhichDay();
		wd.test();
	}

	private void test(){
		String[] notOnThisDay;
		String expected;
		String obtained;

		int numTests = 4;
		for(int i=0; i < numTests; i++){
			switch (i) {
				case 0:{
					notOnThisDay = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
					expected = new String("Saturday");
					obtained = getDay(notOnThisDay);
					printResult(i, expected, obtained);
					break;
				}
				case 1:{
					notOnThisDay = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Friday", "Thursday"};
					expected = new String("Saturday");
					obtained = getDay(notOnThisDay);
					printResult(i, expected, obtained);
					break;
				}
				case 2:{
					notOnThisDay = new String[]{"Sunday", "Monday", "Tuesday", "Thursday", "Friday", "Saturday"};
					expected = new String("Wednesday");
					obtained = getDay(notOnThisDay);
					printResult(i, expected, obtained);
					break;
				}
				case 3:{
					notOnThisDay = new String[]{"Sunday", "Friday", "Tuesday", "Wednesday", "Monday", "Saturday"};
					expected = new String("Thursday");
					obtained = getDay(notOnThisDay);
					printResult(i, expected, obtained);
					break;
				}
			}
		}
	}

	private void printResult(int testNum, String expected, String obtained){
		StringBuilder sb = new StringBuilder();

		sb.append("Case "+testNum);
		if(expected.equals(obtained)) sb.append("\tSuccess");
		else sb.append("\t Fail");
		sb.append("\t expected: "+expected+" obtained: "+obtained);

		System.out.println(sb.toString());
	}
}