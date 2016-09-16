/* https://community.topcoder.com/stat?c=problem_statement&pm=14005 */

import java.io.*;

public class VerySecureEncryption{
	public 	String encrypt(String message, int[] key, int K){
		
		char[] arr = new char[message.length()];
		for(int i=0; i < message.length(); i++){
			arr[i] = message.charAt(i);
		}

		for(int j = 0; j < K; j++){
			char[] temp = new char[message.length()];
			for(int i=0; i < key.length; i++){
				temp[key[i]] = arr[i];
			}

			for(int i=0; i < temp.length; i++){
				arr[i] = temp[i];
			}
		}

		return String.valueOf(arr);
	}

	public static void main(String[] args) {
		VerySecureEncryption vse = new VerySecureEncryption();
		vse.test();
	}

	private void test(){
		String[] message = new String[]{
			"abc",
			"abcde",
			"abcde",
			"uogcodlk"
		};

		int[][] key = new int[][]{
			{1,2,0},
			{4, 3, 2, 1, 0},
			{4, 3, 2, 1, 0},
			{4, 3, 6, 2, 5, 1, 0, 7}
		};

		int[] K = new int[]{1, 1, 2, 44};

		String[] want = new String[]{
			"cab",
			"edcba",
			"abcde",
			"goodluck"
		};

		for(int i=0; i < message.length; i++){
			String got = encrypt(message[i], key[i], K[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got.equals(want[i])) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t want: "+want[i]+"\t got: "+got);

			System.out.println(sb.toString());
		}
	}
}