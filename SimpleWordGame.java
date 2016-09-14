/* https://community.topcoder.com/stat?c=problem_statement&pm=10465 */

import java.io.*;
import java.util.*;

public class SimpleWordGame{
	public int points(String[] player, String[] dictionary){
		HashSet<String> playerSet = new HashSet<String>();
		HashSet<String> dSet = new HashSet<String>();

		for(String p:player){
			playerSet.add(p);
		}

		for(String d:dictionary){
			dSet.add(d);
		}

		Iterator it = playerSet.iterator();

		int score = 0;
		while(it.hasNext()){
			String s = it.next().toString();
			if(dSet.contains(s)){
				score += (s.length() * s.length());
			}
		}

		return score;
	}

	public static void main(String[] args) {
		SimpleWordGame swg = new SimpleWordGame();
		swg.test();
	}

	private void test(){
		String[][] player = new String[][]{
			{ "apple", "orange", "strawberry" },
			{ "apple" },
			{ "orange", "orange" },
			{ "lidi", "o", "lidi", "gnbewjzb", "kten", "ebnelff", "gptsvqx", "rkauxq", "rkauxq", "kfkcdn"}
		};

		String[][] dictionary = new String[][]{
			{ "strawberry", "orange", "grapefruit", "watermelon" },
			{ "strawberry", "orange", "grapefruit", "watermelon" },
			{ "strawberry", "orange", "grapefruit", "watermelon" },
			{ "nava", "wk", "kfkcdn", "lidi", "gptsvqx", "ebnelff", "hgsppdezet", "ulf", "rkauxq", "wcicx"}
		};

		int[] want = new int[]{
			136,
			0,
			36,
			186
		};

		for(int i=0; i < player.length; i++){
			int got = points(player[i], dictionary[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}