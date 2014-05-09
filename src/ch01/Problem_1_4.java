package ch01;

public class Problem_1_4 {
	//find the index of the last non-space character 
	private int lastNonSpaceIndex(char[] c){
		for(int i=c.length-1;i>=0;i--)
			if(c[i] != ' ')
				return i;
		return 0;//all characters are spaces
	}
	public char[] replaceSpaces(char[] c){
		int lastIndex = lastNonSpaceIndex(c);
		int i=c.length-1;
		//scan backwards
		while(lastIndex>0 && i>0){
			if(c[lastIndex] == ' '){
				//end of a word, replace a '%20'
				c[i--]='0';
				c[i--]='2';
				c[i--]='%';
			}
			else
				//otherwise, copy the character from c[lastIndex] to c[i], then i--, lastIndex--
				c[i--] = c[lastIndex--];	
			
			System.out.println(i+" "+lastIndex);
			System.out.println(c);
		}
		return c;
	}
	public static void main(String[] args){
		char[] c = {'M','r',' ','J','o','h','n',' ',' '};
		System.out.println(new Problem_1_4().replaceSpaces(c));
	}

}
