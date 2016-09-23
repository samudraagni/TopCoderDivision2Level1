/* https://community.topcoder.com/stat?c=problem_statement&pm=12578 
   Submission successful for 249.98 points.
*/

import java.util.*;

public class ShoutterDiv2{
	public class Rabbit implements Comparator<Rabbit>, Comparable<Rabbit>{
		int arrival;
		int dept;
		
		public Rabbit(){

		}

		public Rabbit(int arr, int dept){
			this.arrival = arr;
			this.dept = dept;
		}

		/* sort by departure times */
		public int compareTo(Rabbit r2){
			return this.dept - r2.dept;
		}

		public int compare(Rabbit r1, Rabbit r2){
			return r1.dept - r2.dept;
		}
		
		public int getArr(){
			return this.arrival;
		}

		public int getDept(){
			return this.dept;
		}
	}

	public int count(int[] s, int[] t){
		List<Rabbit> r = new ArrayList<Rabbit>();

		for(int i=0; i < s.length; i++){
			Rabbit r1 = new Rabbit(s[i], t[i]);
			r.add(r1);
		}

		Collections.sort(r, new Rabbit());

		int inc = 0;
		for(int i=0; i < r.size(); i++){
			Rabbit r1 = r.get(i);
			for(int j=i+1; j < r.size(); j++){
				Rabbit r2 = r.get(j);

				if(!(r1.getDept() < r2.getArr() && r1.getArr() < r2.getArr())){
					inc += 1;
				}
			}
		}

		return inc;
	}


	public static void main(String[] args) {
		ShoutterDiv2 sd = new ShoutterDiv2();
		sd.test();
	}

	private void test(){
		int[][] s = new int[][]{
			{9,26,8,35,3,58,91,24,10,26,22,18,15,12,15,27,15,60,76,19,12,16,37,35,25,4,22,47,65,3,2,23,26,33,7,11,34,74,67,32,15,45,20,53,60,25,74,13,44,51},
			{0},
			{0, 0, 0}
		};
		int[][] t = new int[][]{
			{26,62,80,80,52,83,100,71,20,73,23,32,80,37,34,55,51,86,97,89,17,81,74,94,79,85,77,97,87,8,70,46,58,70,97,35,80,76,82,80,19,56,65,62,80,49,79,28,75,78},
			{100},
			{1, 1, 1}
		};

		int[] want = new int[]{830, 0, 3};

		for(int i=0; i < s.length; i++){
			int got = count(s[i], t[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want "+want[i]);

			System.out.println(sb.toString());
		}
	}
}