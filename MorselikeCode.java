/* https://community.topcoder.com/stat?c=problem_statement&pm=8152 */

import java.util.*;

public class MorselikeCode{
	public String decrypt(String[] library, String message){
		HashMap<String, String> map = new HashMap<String, String>();
		for(String lib : library){
			String[] parts = lib.split(" ");
			map.put(parts[1], parts[0]);
		}

		String[] mparts = message.split(" ");
		StringBuilder sb = new StringBuilder();
		for(String mpart : mparts){
			if(map.containsKey(mpart)){
				sb.append(map.get(mpart));
			}
			else{
				sb.append("?");
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		MorselikeCode mlc = new MorselikeCode();
		mlc.test();
	}

	private void test(){
		String[][] library = new String[][]{
			{"O ---",
 			 "S ..."},
 			{"O ---"},
 			{"H -",
			 "E .",
			 "L --",
			 "L ..",
			 "O -."},
			{"H -.-.-.-.-.-.-.-.-.-.",
			 "I .-.-.-.-.-.-.-.-.-.-",
			 "K -.-.-.-.-.",
			 "E .-.-.-.-.-"},
			{"O ---",
			 "S ...",
			 "B -...",
			 "T -",
			 "R .-.",
			 "E .",
			 "N -.",
			 "X -..-",
			 "D -.." },
			{"B -...",
			 "N -.",
			 "H ....",
			 "O --",
			 "Z --..",
			 "G ---",
			 "I ..",
			 "J .---" },
			{"A --",
			 "B -.",
			 "N ...-",
			 "I --..",
			 "F -.-.-."}
		};

		String[] message = new String[]{
			"... --- ...",
			"... --- ...",
			"- . -- .. -.",
			"-.-.-.-.-.-.-.-.-.-. .-.-.-.-.-.-.-.-.-.-",
			"-... --- ... - --- -. .-. . -.. ... --- -..-",
			"--- -- -... .- -. .- -. .-",
			"-. -- -.-.-. -.-.-. --- --.. ...- .-..--."
		};

		String[] want = new String[]{
			"SOS",
			"?O?",
			"HELLO",
			"HI",
			"BOSTONREDSOX",
			"GOB?N?N?",
			"BAFF?IN?"
		};

		for(int i=0; i < library.length; i++){
			String got = decrypt(library[i], message[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got.equals(want[i])) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
}