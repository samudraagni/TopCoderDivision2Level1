public class EllysNewNickname{
	public int getLength(String nickname){
		int count = nickname.length();
		String vowels = "aeiouy";
		
		for(int i=0; i < nickname.length(); ){
			if(vowels.indexOf(nickname.charAt(i)) != -1){
				/* continue to find the next consecutive vowels */
				while(i+1 < nickname.length() && vowels.indexOf(nickname.charAt(i+1)) != -1){
					count--;
					i++;
				}
			}
			i++;
		}
		
		return count;
	}	

	public static void main(String[] args) {
		EllysNewNickname enn = new EllysNewNickname();
		enn.test();
	}

	private void test(){
		String[] nicknames = new String[]{"tourist", "eagaeoppooaaa", "esprit", "ayayayayayaya","wuuut","naaaaaaaanaaaanaananaaaaabaaaaaaaatmaaaaan"};
		int[] want = new int[]{6, 6, 6, 1, 3, 16};

		for(int i=0; i < nicknames.length; i++){
			int got = getLength(nicknames[i]);

			StringBuilder sb = new StringBuilder();
			sb.append("Case "+i);
			if(got == want[i]) sb.append("\t Success");
			else sb.append("\t Fail");
			sb.append("\t Got: "+got+"\t want: "+want[i]);
			
			System.out.println(sb.toString());
		}
	}
}