package NetEasi4;
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int [][] appro = new int [n+1][n+1];
		for(int i=0; i<m; i++) {
			appro[scan.nextInt()][scan.nextInt()] = 1;
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(appro[i][j] ==1) {
					for(int k = 1; k<=n; k++) {
						if(appro[j][k] ==1) {
							appro[i][k] =1;
						}
					}
				}
			}
		}
		int res = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(appro[i][j] ==1 && appro[j][i] ==1 && i!=j) {
					res ++;
				}
			}
		}
		System.out.println(res/2);
	}
}
