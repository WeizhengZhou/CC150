package ch05;

public class Problem_5_2 {
	

	public int realToBinary(double d){
		Bit bt = new Bit();
		int res = 0;
		
		for(int i =31;i>=0;i--){
			d *= 2;
			if(d>=1){
				System.out.println("Set " + i + "th bit to be one");
				res = bt.setBit(res, i);
				d -= 1;
			}
			Bit.print(res);
		}
		if(d == 0){
			return res;
		}
		else{
			System.out.println("Error");
			return 0;
		}
		
	}
	public static void main(String[] args){
//		Bit.print(0 | 1<<31);
//		Problem_5_2 prob = new Problem_5_2();
//		prob.realToBinary(0.5);
//		
		
	}

}
