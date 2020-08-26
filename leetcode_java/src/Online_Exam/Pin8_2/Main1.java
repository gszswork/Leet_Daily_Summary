package Pin8_2;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] c1 = new int[300][300];
		int[][] c2 = new int[300][300];
		
		while(input.hasNext()) {
			String s = input.next();
			
			for(int i = 0; i < 300; i++)
				for(int j = 0; j < 300; j++) {
					c1[i][j] = 0;
				}
			
			for(int i = 0; i <= 2; i++) {
				c1[s.charAt(i)][s.charAt(5 - i)]++;
				c1[s.charAt(5 - i)][s.charAt(i)]++;
			}
			
			for(int i = 6; i <= 8; i++) {
				c2[s.charAt(i)][s.charAt(17 - i)]++;
				c2[s.charAt(17 - i)][s.charAt(i)]++;
			}
			
			boolean result = true;
			for(int i = 0; i <= 2; i++) {
				if(c1[s.charAt(i)][s.charAt(5 - i)] != c2[s.charAt(i)][s.charAt(5 - i)]) {
					result = false;
					break;
				}
			}
			
			if(result)
				System.out.println("TRUE");
			else
				System.out.println("FALSE");
		}
	}
}
}
