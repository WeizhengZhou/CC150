package ch05;

public class Problem_5_1 {
	public int insert(int n, int m, int i, int j){
		//create mask 11111_00000_11
		//all zeros from bit i to bit j
		int mask = ~(((1 << (j+1)) - 1) << i);
		//clear bits [i,j] in n
		int temp = n & mask;
		//shift m i bits, and OR operation to set bits in n
		return temp | (m << i);
	}
	public static void main(String[] args){
		Problem_5_1 prob = new Problem_5_1();
		int n = 0b1000000000;
		int m = 0b10011;
		int i = 2;
		int j = 6;
	
		Bit.print(prob.insert(n, m, i, j));
	}

}
