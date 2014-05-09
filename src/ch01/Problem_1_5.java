package ch01;

public class Problem_1_5 {
	public String compression(String s){
		StringBuilder sb = new StringBuilder();
		char curChar = s.charAt(0);
		int  count = 1;
		for(int i=1;i<s.length();i++){
			if(s.charAt(i) == curChar)
				count++;
			else{				
				sb.append(curChar);
				sb.append(count);
				curChar = s.charAt(i);
				count=1;
			}	
//			System.out.println(sb.toString());
		}
		sb.append(curChar);
		sb.append(count);
		
		String res = sb.toString();
		if(res.length() < s.length())
			return res;
		else 
			return s;
	}
	public static void main(String[] args){
//		String s = "aabcccccaaa";
		String s = "accddfghi";
		System.out.println(new Problem_1_5().compression(s));
	}

}
