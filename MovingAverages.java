/* Problem page: https://community.topcoder.com/stat?c=problem_statement&pm=2924*/
import java.io.*;
import java.util.*;

public class MovingAverages{
	public int[] calculate(String[] times, int n){

		int[] timesInSeconds = convertToSeconds(times);
		ArrayList<Integer> vals = new ArrayList<Integer>();

		int firstSum = 0;
		for(int i=0; i < n; i++){
			firstSum += timesInSeconds[i];
		}
		
		int pos = 0;
		int val = (int)(Math.floor((firstSum * 1.0)/n));
		vals.add(pos++, val);
		
		for(int i=n; i < times.length; i++){
			firstSum -= timesInSeconds[i-n];
			firstSum += timesInSeconds[i];

			val = (int)(Math.floor((firstSum * 1.0)/n));

			vals.add(pos++, val);
		}
		
		int[] retval = new int[vals.size()];
		for(int i=0; i < vals.size(); i++){
			retval[i] = vals.get(i);
		}

		return retval;
	}

	private int[] convertToSeconds(String[] times){
		int minuteMultiplier = 60;
		int hourMultiplier = 3600;

		int[] retval = new int[times.length];
		for(int i=0; i < times.length; i++){
			String val = times[i];
			String[] parts = val.split(":");

			int hourInSeconds = Integer.parseInt(parts[0]) * hourMultiplier;
			int minInSeconds = Integer.parseInt(parts[1]) * minuteMultiplier;
			int seconds = Integer.parseInt(parts[2]);

			retval[i] = hourInSeconds + minInSeconds + seconds;
		}

		return retval;
	}

	public static void main(String[] args) {
		MovingAverages ma = new MovingAverages();
		ma.test();
	}

	private void test(){
		String[] times;
		int n;

		int numcases = 3;
		for(int i=0; i < numcases; i++){
			switch (i) {
				case 0:{
					times = new String[]{"01:19:10", "01:17:40", "01:19:44", "01:17:23", "01:17:07"};
					n = 3;
					int[] want = new int[]{4731, 4695, 4684};
					int[] got = calculate(times, n);
					printResult(i, want, got);
					break;
				}
				case 1:{
					times = new String[]{"01:19:10", "01:17:40", "01:19:44", "01:17:23", "01:17:07"};
					n = 1;
					int[] want = new int[]{ 4750,  4660,  4784,  4643,  4627 };
					int[] got = calculate(times, n);
					printResult(i, want, got);
					break;
				}
				case 2:{
					times = new String[]{"01:19:10", "01:17:40", "01:19:44", "01:17:23", "01:17:07"};
					n = 5;
					int[] want = new int[]{ 4692 };
					int[] got = calculate(times, n);
					printResult(i, want, got);
					break;
				}
			}
		}
	}

	private void printResult(int casenum, int[] want, int[] got){
		StringBuilder sb = new StringBuilder();

		boolean pass = true;
		if(want.length != got.length) pass = false;
		else{
			for(int i=0; i < want.length; i++){
				if(want[i] != got[i]){
					pass = false;
					break;
				}
			}
		}
		sb.append("Case "+casenum);
		if(pass) sb.append("\t Success");
		else sb.append("\t Fail");
		sb.append("\nwant: "+Arrays.toString(want)+"\ngot: "+Arrays.toString(got)+"\n");

		System.out.println(sb.toString());
	}
}