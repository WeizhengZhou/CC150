package ch01;

import java.util.Arrays;
import java.util.Hashtable;
public class Problem_1_3 {
	public boolean isPermutation_Hashtable(String s1, String s2){
		if(s1.length() != s2.length()) 
			return false;
		
		Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>();
		//put all characters in s1 to the hash table
		for(int i=0;i<s1.length();i++){
			char k = s1.charAt(i);
			if(!ht.containsKey(k))
				ht.put(k, 1);
			else{			
				ht.put(k, ht.get(k)+1);				
			}	
			System.out.println(ht.toString());
		}
		//empty the hash table according to the string s2
		for(int i=0;i<s2.length();i++){
			char k = s2.charAt(i);
			if(ht.containsKey(k))
			    ht.put(k, ht.get(k)-1);
			else
				return false;				
			if(ht.get(k) == 0)
				ht.remove(k);
			System.out.println(ht.toString());
		}
		//empty hash table means s1 is a permutation of s2
		if(ht.isEmpty())
			return true;
		else
			return false;
	}
	public boolean isPermutation_Sort(String s1, String s2){
		if(s1.length() != s2.length()) 
			return false;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		for(int i=0;i<s1.length();i++){
			if(c1[i]!=c2[i])
				return false;
		}
		return true;
	}
	public boolean isPermutation_Count(String s1, String s2){
		if(s1.length() != s2.length()) 
			return false;
		int[] record = new int[256];
		for(int i=0;i<s1.length();i++)
			record[s1.charAt(i)]++;
		for(int i=0;i<s2.length();i++){
			record[s2.charAt(i)]--;
			if(record[s2.charAt(i)] < 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args){
		String s1 = "abcc";
		String s2 = "cabc";
		Problem_1_3 prob = new Problem_1_3();
//		System.out.println(prob.isPermutation_Hashtable(s1, s2));
//		System.out.println(prob.isPermutation_Sort(s1, s2));
		System.out.println(prob.isPermutation_Count(s1, s2));
	}

}
