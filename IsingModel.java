/* https://community.topcoder.com/stat?c=problem_statement&pm=4746 */

public class IsingModel{
	public int energy(String[] spins){

		int count = 0;
		for(int i=0; i < spins.length; i++){
			for(int j=0; j < spins[i].length(); j++){
				char cur = spins[i].charAt(j);
				char right = (j+1 < spins[i].length())? spins[i].charAt(j+1):'*';
				char bottom = (i+1 < spins.length)? spins[i+1].charAt(j):'*';

				if(cur == right) count--;
				else if(right != '*' && cur != right) count++;

				if(cur == bottom) count--;
				else if(bottom != '*' && cur != bottom) count++;
			}
		}

		return count;
	}

	public static void main(String[] args){
		IsingModel im = new IsingModel();
		im.test();
	}

	private void test(){
		String[][] spins = new String[][]{
			{"-++",
 			 "+-+"},
 			{"+"},
 			{"++-+",
			 "-++-",
			 "+-+-",
			 "++++"},
			{"----",
			 "---+",
			 "-+++",
			 "++++"} 
		};

		int[] want = new int[]{3, 0, 4, -12};

		for(int i=0; i < spins.length; i++){
			int got = energy(spins[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Pass");
			else sb.append("\t Fail");
			sb.append("\t got: "+got+"\t want: "+want[i]);

			System.out.println(sb.toString());
		}
	}
	
}