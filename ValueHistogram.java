/* https://community.topcoder.com/stat?c=problem_statement&pm=12275 */

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class ValueHistogram{
	public String[] build(int[] values){
		String baseString = "..........";
		
		int[] freqs = new int[10];
		for(int i=0; i < 10; i++){
			freqs[i] = 0; 
		}

		int maxfreq = Integer.MIN_VALUE;
		for(int v : values){
			freqs[v]++;
			if(freqs[v] > maxfreq){
				maxfreq = freqs[v];
			}
		}

		maxfreq++;
		String[] vals = new String[maxfreq];

		for(int i=0; i < maxfreq; i++){
			vals[i] = baseString;
		}

		for(int v:values){
			int freq = freqs[v];
			if(freq > 0){
				int index = maxfreq - freq;
				StringBuilder sb = new StringBuilder(vals[index]);
				sb.setCharAt(v,'X');
				vals[index]  = sb.toString();
				freqs[v]--;
			}
		}
		
		return vals;
	}	

	public static void main(String[] args) {
		ValueHistogram vh = new ValueHistogram();
		vh.test();
	}

	private void test(){
		int[][] values = new int[][]{
			{2, 3, 5, 5, 5, 2, 0, 8},
			{9, 9, 9, 9},
			{6, 4, 0, 0, 3, 9, 8, 8},
			{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
			{6, 2, 3, 3, 3, 7, 8, 1, 0, 9, 2, 2, 4, 3}
		};

		String[][] want = new String[][]{
			{"..........", ".....X....", "..X..X....", "X.XX.X..X." },
			{"..........", ".........X", ".........X", ".........X", ".........X" },
			{"..........", "X.......X.", "X..XX.X.XX" },
			{"..........", "XXXXXXXXXX" },
			{"..........", "...X......", "..XX......", "..XX......", "XXXXX.XXXX" }
		};

		for(int i=0; i < values.length; i++){
			String[] got = build(values[i]);

			/* print result */
			boolean match = true;
			StringBuilder sb = new StringBuilder();
			if(got.length != want[i].length) match = false;
			else
			{
				for(int j=0; j < got.length; j++){
					if(!got[j].equals(want[i][j])){
						match = false;
						break;
					}
				}
			}
			sb.append("Case "+i);
			if(match) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\n want:\n"+Arrays.toString(want[i])+"\n got:\n"+Arrays.toString(got));

			System.out.println(sb.toString());
		}
	}
}