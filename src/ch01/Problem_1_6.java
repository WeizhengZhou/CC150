package ch01;

import java.util.Arrays;

public class Problem_1_6 {
	public int[][] rotate90(int[][] m){
		int n = m.length;//the length of the matrix
		for(int k=0;k<n/2;k++){//k goes from 0 to half size of matrix
			for(int i=k;i<n-k-1;i++){//i as the current swap index
				int temp = m[i][k];
				m[i][k] = m[n-k-1][i];
				m[n-k-1][i] = m[n-i-1][n-k-1];
				m[n-i-1][n-k-1] = m[k][n-i-1];
				m[k][n-i-1] = temp;			
			}
		}
		return m;
	}
	public static void main(String[] args){
		int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(Arrays.deepToString(m));
//		int[][] m={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	    int[][] res = new Problem_1_6().rotate90(m);
	    
	    System.out.println(Arrays.deepToString(res));
	}

}
