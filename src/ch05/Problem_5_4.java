package ch05;

public class Problem_5_4 {
	
	public static void main(String[] args){
		for(int i=1;i<=16;i++){
			System.out.println(i + "---------" + ((i & (i-1)) == 0) );
		} 
	}

}
