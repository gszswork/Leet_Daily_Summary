package Cube;

public class Main {
	int [][] cube = { {0,1,2,3,4,5},{1,5,2,3,0,4},{2,1,5,0,4,3}, {3,1,0,5,4,2},{4,0,2,3,5,1},{5,4,2,3,1,0} };
	// variable 'cube' save all rotated cases of one cube
	/* 暴力枚举，cube矩阵中列出了一个骰子所有不同摆法的索引
	 * 在sameCube中，使用cmp来代表b，将cmp设置不同的上下面并不停翻转查看是否与a吻合
	 * 利用sameString函数判断，如果吻合则返回true, 否则在sameCube函数最后返回false 
	 * */
	public boolean sameCube(int [] a, int [] b) {
		int [] cmp = new int[a.length]; 
		//list cmp is for comparison, different rotated cases of b is saved in cmp
		
		for (int i=0; i< 6; i++) {
			for (int j=0; j<6; j++) {
				cmp[j] = b[cube[i][j]];
				// set cmp as one rotated case of b:list
			}
			if(sameString(a, cmp)) {
				return true;
			}
			for(int j=0; j<3; j++) {
				// s2[3]=s1[5], s2[4]=s1[6], s2[5]=s1[4], s2[6]=s1[3]
				// index is -1 in list
				int tmp = cmp[1];
				cmp[1] = cmp[2];
				cmp[2] = cmp[4];
				cmp[4] = cmp[3];
				cmp[3] = tmp;
				if(sameString(a, cmp)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean sameString(int [] a, int [] b) {
		int n = a.length;
		for(int i=0; i<n; i++) {
			if(a[i]!=b[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]) {
		
	}
}
