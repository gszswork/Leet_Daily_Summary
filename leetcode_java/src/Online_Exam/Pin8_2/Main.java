package Pin8_2;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		//动态规划
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int P = scan.nextInt();
		int [][] dp = new int [N+1][M+1];
		int [][] Nm = new int[N+1][3];
		int [][] Mm = new int [M+1][3];
		
		for(int i=1;i<=N; i++) {
			Nm[i][1] = scan.nextInt();
			Nm[i][2] = scan.nextInt();
		}
		for(int i=1;i<=M; i++) {
			Mm[i][1] = scan.nextInt();
			Mm[i][2] = scan.nextInt();
		}
		for(int i=1;i<=N; i++) {
			for (int j=1;j <=M; j++) {
				//if (Nm[i][])
			}
		}
	}
}
