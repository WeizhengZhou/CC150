package ch05;


public class Bit{
	
	public static void print(int a){
		System.out.println(Integer.toBinaryString(a));
	}
	
	public boolean getBit(int num, int i){
		return (num & (1 << i)) != 0;
	}
	public int setBit(int num, int i){
		return num | (1 << i);
	}
	public int clearBit(int num, int i){
		int mask = ~(1<<i);
		return num & mask;
	}
	public int clearBitsMSBToI(int num, int i){
		int mask = (1 << i) -1;
		return mask & num;
	}
	public int clearBitsItoLSB(int num, int i){
		int mask = ~((1 << (i+1))-1);
		return mask & num;
	}
	public int updateBit(int num, int i, int v){
		
		if(v == 1)
		    return setBit(num,i);
		else
			return clearBit(num,i);
	}
	
	public static void main(String[] args){
        int a = 0b1010;
		Bit bt = new Bit();
		System.out.println(bt.getBit(a, 3));
		Bit.print(bt.setBit(a,2));
		Bit.print(bt.clearBit(a, 3));
		
		Bit.print(bt.clearBitsMSBToI(0b1111, 2));
		Bit.print(bt.clearBitsItoLSB(0b1111, 1));
		
	}


}
