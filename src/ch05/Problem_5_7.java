package ch05;

public class Problem_5_7 {
	public int missInteger(int[] A, int l, int r){
		int n = r-l+1;
		if(n == 1)
			return A[n];
		
		int d = (int) Math.log(n) - 1;
		int onesCount = 0;
		for(int i=l;i<=r;i++){
			 //dth bit of A[i]
			 boolean bit = ((A[i] & (1 << d)) != 0);
			 if(bit)
				 onesCount ++;
		}
		if(onesCount != n/2)
			return missInteger(A,l+n/2,r);
		else
			return missInteger(A,l,l+n/2-1);
	}
	
	public static void main(String[] args){
		int[] A = new int[]{0,1,3};
		Problem_5_7 prob = new Problem_5_7();
		prob.missInteger(A, 0, 3);

	}

}
