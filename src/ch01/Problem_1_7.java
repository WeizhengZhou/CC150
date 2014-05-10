package ch01;

import java.util.Arrays;

public class Problem_1_7 {
	public int[][] setMatrixZeros(int[][] m){
		int nRow = m.length;
		int nColumn = m[0].length;
		//find all rows and columns should be set to zero
		boolean[] isZeroRow = new boolean[nRow];
		boolean[] isZeroColumn = new boolean[nColumn];
		for(int i=0;i<nRow;i++){
			for(int j=0;j<nColumn;j++){
				if(m[i][j]==0){
					isZeroRow[i] = true;
					isZeroColumn[j] = true;
				}
			}
		}
		//set zeros
		for(int i=0;i<nRow;i++){
			for(int j=0;j<nColumn;j++){
				if(isZeroRow[i] == true || isZeroColumn[j] == true){
					m[i][j]=0;
				}
			}
		}
		return m;
		
	}
	public static void main(String[] args){
		int[][] m = {{1,1,0},{0,1,1},{1,1,1}};
		System.out.println(Arrays.deepToString(m));
		int[][] res = new Problem_1_7().setMatrixZeros(m);
		System.out.println(Arrays.deepToString(res));
		
	}

}
