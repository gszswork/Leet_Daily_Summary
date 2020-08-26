package Pin8_2;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int K = scan.nextInt();
		int N = scan.nextInt();
		int traceBack = 0;
		for(int i=0; i< N; i++) {
			K = K - scan.nextInt();
			if (K==0) {
				System.out.println("paradox");
			}
			if( K < 0) {
				K = -K;
				traceBack ++;
			}
		}
		System.out.println(K + " " + traceBack);
	}
}
