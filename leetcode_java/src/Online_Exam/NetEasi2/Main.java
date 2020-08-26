package NetEasi2;

import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner (System.in);
		int T = scan.nextInt();
		
		for (int round=0; round<T; round++) {
			int n = scan.nextInt();
			
			//int sec = 0; // result dp no need
			int [] a = new int[n];
			int [] b = new int[n];
			
			int [] dp = new int [n];
			for(int i=0; i<n; i++) {
				a[i] = scan.nextInt();
			}
			for(int i=0; i<n-1; i++) {
				b[i+1] = scan.nextInt();
			}
			for(int i=0; i<n; i++) {
				if(i==0) {
					// the first 
					dp[i] = a[i];
					continue;
				}
				if(i==1) {
					dp[i] = min(a[0]+a[1], b[1]);
					continue;
				}
				dp[i] = min(dp[i-1]+a[i], dp[i-2]+b[i]);
					
			}
			
			///#### change res here 
			int res = dp[n-1];
			res = 36000;
			
			// time output:
			int hour = 8;
			int min = 0;
			int sec = 0;
			int secAdd = res%60;
			int minAdd = (res/60) % 60;
			int hourAdd = (res/3600); // 目前只考虑在当天关门
			//System.out.println("addTime: "+ hourAdd+ " "+ minAdd+" "+secAdd);
			hour += hourAdd;
			min  += minAdd;
			sec  += secAdd;
			boolean am_pm = true;
			int aamm = hour /12;
			if (aamm%2==1) {am_pm = false; if(hour>12) {hour = hour%12;} }
			
			if(hour<=12&&hour>=10) {
				System.out.print(hour+":");
			}else {
				System.out.print("0"+hour+":");
			}
			
			if(min<10) {
				System.out.print("0"+min+":");
			}else {
				System.out.print(min+":");
			}
			
			if(sec<10) {
				System.out.print("0"+sec+" ");
			}else {
				System.out.print(sec+" ");
			}
			
			if (am_pm) {
				System.out.println("am");
			}
			else {
				System.out.println("pm");
			}
		}
	}
	public static int min(int a, int b) {
		return a<b?a:b;
	}
}
