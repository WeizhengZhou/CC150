package ch01;

import java.util.Hashtable;
import java.util.Arrays;

public class Problem_1_1 {
	public boolean isUnique_Hashtable(String s){
		Hashtable<Integer,Character> ht = new Hashtable<Integer,Character>();
		for(int i=0;i<s.length();i++){
			if(ht.contains(s.charAt(i)))
				return false;
			else
				ht.put(i, s.charAt(i));
		}		
		return true;
	}
	public boolean isUnique_Array(String s){
		final int MaxPossibleCode = 256;//Assuming ASCII code
		if (s.length() > MaxPossibleCode) return false;//quick check
		int[] record = new int[MaxPossibleCode];

		for(int i=0;i<record.length;i++)
			record[i]=0;

		for(int i=0;i<s.length();i++){
			char a = s.charAt(i);   
			int index = (int) a;
			System.out.println(a + " = " + index);			
			if(record[index] == 0)
				record[index] = 1;
			else
				return false;
		}	
		return true;		
	}
	public boolean isUnique_Sort(String s){
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		String t = new String(charArray);
		
		for(int i=0;i<t.length()-1;i++){
			if (t.charAt(i) == t.charAt(i+1))
				return false;
		}
		return true;
	}
	public static void main(String[] args){
		Problem_1_1 prob = new Problem_1_1();
		String s = "abcdef";
//		System.out.println(prob.isUnique_Hashtable(s));
//		System.out.println(prob.isUnique_Array(s));
		System.out.println(prob.isUnique_Sort(s));
	}

}
