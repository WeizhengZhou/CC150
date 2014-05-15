package ch05;

public class Problem_5_5 {
	public int diffNumBits(int a, int b){
		int c = a^b;
		int n = 0;
		while(c != 0){
			if((c & 1) != 0 )
				n++;
			c = c >> 1;
//			Bit.print(c);
//			System.out.println(n);
		}
		return n;
	
	}

	public static void main(String[] args){
		Problem_5_5 prob = new Problem_5_5();
		int n = prob.diffNumBits(31, 14);
		System.out.println(n);
	}
}
