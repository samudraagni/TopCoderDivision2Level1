/* https://community.topcoder.com/stat?c=problem_statement&pm=7600 
	249.99/250
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TournamentsAmbiguityNumber{
	public int scrutinizeTable(String[] table){
		int count = 0;

		if(table.length <= 2) return count;

		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();//defeat list
		for(int i=0; i < table.length; i++){
			String s = table[i];
			map.put(i, new HashSet<Integer>());
			HashSet<Integer> hs = map.get(i);
			
			for(int j=0; j < s.length(); j++){
				if(s.charAt(j) == '1'){
					hs.add(j);
				}
			}

			map.put(i, hs);
		}

		Set<Integer> keys = map.keySet();
		for(Integer key : keys){
			HashSet<Integer> defeatList = map.get(key);
			if(defeatList.size() > 0){
				for(Integer d : defeatList){
					HashSet<Integer> sdl = map.get(d);

					if(sdl.size() > 0){
						for(Integer sd : sdl){
							HashSet<Integer> tdl = map.get(sd);
							
							if(tdl.size() > 0){
								if(tdl.contains(key)) count++;
							}
						}
					}
				}
			}
		}

		return count;
	}


	public static void main(String[] args){
		TournamentsAmbiguityNumber tam = new TournamentsAmbiguityNumber();
		tam.test();
	}

	private void test(){
		String[][] table = new String[][]{
			{"-10",
			 "0-1",
			 "10-"},
			{"----",
			 "----",
			 "----",
			 "----"},
			{"-1",
 			"0-"},
 			{"--1-10-1---1--1-00",
			 "--0110000--0---10-",
			 "01--00000100-00011",
			 "-0---0010-11110100",
			 "001--01-00-0001-1-",
			 "11111--100--1-1-01",
			 "-1110--00110-11-01",
			 "0110-01--100110-10",
			 "-111111---01--0-01",
			 "--0-1100----10011-",
			 "--10--011--1--101-",
			 "01101-110-0--1-0-1",
			 "---010-0-0---00-11",
			 "--101-00-1-01-0-0-",
			 "0-110001110-11-110",
			 "-010-----011--0--0",
			 "11010110100-010--0",
			 "1-01-0010--00-111-"} 
		};

		int[] want = new int[]{3, 0, 0, 198};

		for(int i=0; i < table.length; i++){
			int got = scrutinizeTable(table[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}