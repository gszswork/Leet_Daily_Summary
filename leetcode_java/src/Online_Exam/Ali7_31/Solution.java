package Online_Exam.Ali7_31;

import java.util.Scanner;

public class Solution {

	public int dfs(char [][] mat, int sx, int sy, int ex, int ey, int n, int m) {
		
		int x = sx, y = sy;
		int [][] steps = new int [n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				steps[i][j] = -1;
			}
		}
		steps [x][y] = 0;
		for(int i=-1; i<=1; i++) {
			for(int j=-1; j<=1; j++) {
				if(x+i>=0 && x+i<n && y+j>=0 && y+j<m && !(i==0&&j==0) && steps[x+i][y+j] ==-1) {
					int newX = x+i;
					int newY = y+j;
					if(mat[x][y]!=mat[newX][newY]) {
						steps[newX][newY] = steps[x][y] + 5;
						if(newX==ex && newY==ey) {
							return steps[newX][newY];
						}
						dfs(mat, newX,newY,ex,ey,n,m);
					}
					else {
						if(mat[x][y] == mat[newX][newY] && mat[x][y] == 'S'	) {
							steps[newX][newY] = steps[x][y] + 2;
							if(newX==ex && newY==ey) {
								return steps[newX][newY];
							}
							dfs(mat, newX,newY,ex,ey,n,m);
						}
						else {
							steps[newX][newY] = steps[x][y] + 3;
							if(newX==ex && newY==ey) {
								return steps[newX][newY];
							}
							dfs(mat, newX,newY,ex,ey,n,m);
						}
					}
					
				}
			}
		}
		return -1;
	}
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int q = scan.nextInt();
		char [][] mat = new char [n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				mat[i] = scan.nextLine().toCharArray();
			}
		}
		Solution sol = new Solution();
		for(int num=0; num<q; num++) {
			int sx = scan.nextInt() - 1;
			int sy = scan.nextInt() - 1;
			int ex = scan.nextInt() - 1;
			int ey = scan.nextInt() - 1;
			System.out.println(sol.dfs(mat, sx, sy, ex, ey, n, num));
		}

	}
}
