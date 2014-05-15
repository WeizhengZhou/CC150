package ch05;

public class Problem_5_6 {
	
	public int swapOddEven(int n){
		int evenMask = 0xaaaaaaaa;
		int oddMask = ~evenMask;
		Bit.print(evenMask);
		Bit.print(oddMask);
		
		int even = n & evenMask;
		int odd = n & oddMask;
		
		int res =  (even >> 1) | (odd<<1);
	
		return res;
	}
	
	public static void main(String[] args){
		Problem_5_6 prob = new Problem_5_6();
		int res = prob.swapOddEven(0b010101010);
		Bit.print(res);		
	}
	

}