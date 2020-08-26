package Pin8_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Main m = new Main();
		ArrayList<Integer> res = new ArrayList<Integer>();
		ArrayList<int []> shai = new ArrayList<int []>();
		Scanner scan = new Scanner(System.in);
		
		
		int N = scan.nextInt();
		int [] newShai = new int[7];

		for(int j=1; j<=6;  j++) {
			newShai[j] = scan.nextInt();
			
		}
		shai.add(newShai);
		res.add(1);
		
		for(int i=1; i<N; i++) {
			boolean addNew = true;
			int [] scanShai = new int [7];
			for(int j=1; j<=6;  j++) {
				scanShai[j] = scan.nextInt();
			}
			
			for(int num=0; num<res.size(); num++) {
				
				if(m.judge(shai.get(num), scanShai)) {
//					System.out.println(i +" "+num);
					addNew = false;
					res.set(num, res.get(num) + 1);
				}

			}
			if(addNew) {
				res.add(1);
				shai.add(scanShai);
			}
			
		}
		
		System.out.println(res.size());
		for(int i=0; i<res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}
	}
	public boolean judge(int [] old, int [] ne) {
		if(old[1]==ne[1] && old[2]==ne[2] && old[3]==ne[3] && old[4]==ne[4] && old[5]==ne[5] && old[6]==ne[6]) {
//			System.out.println("full");
			return true;
		}
		if(old[1]==ne[6] && old[2]==ne[5] && old[3]==ne[3] && old[4]==ne[4] && old[5]==ne[1] && old[6]==ne[2]) {
			//top 1
//			System.out.println("t1");
			return true;
		}
		if(old[1]==ne[2] && old[2]==ne[1] && old[3]==ne[3] && old[4]==ne[4] && old[5]==ne[6] && old[6]==ne[5] ) {
//			System.out.println("t2");
			return true;
		}
		if(old[1]==ne[5] && old[2]==ne[6] && old[3]==ne[3] && old[4]==ne[4] && old[5]==ne[2] && old[6]==ne[1] ) {
//			System.out.println("t3");
			return true;
		}
		if(old[1]==ne[3] && old[2]==ne[4] && old[3]==ne[2] && old[4]==ne[1] && old[5]==ne[5] && old[6]==ne[6] ) {
			// front 1
//			System.out.println("f1");
			return true;
		}
		if(old[1]==ne[2] && old[2]==ne[1] && old[3]==ne[4] && old[4]==ne[3] && old[5]==ne[5] && old[6]==ne[6] ) {
//			System.out.println("f2");
			return true;
		}
		if(old[1]==ne[4] && old[2]==ne[3] && old[3]==ne[1] && old[4]==ne[2] && old[5]==ne[5] && old[6]==ne[6]) {
			//System.out.println("front3");
//			System.out.println("f3");
			return true;
		}
		if(old[1]==ne[1] && old[2]==ne[2] && old[3]==ne[6] && old[4]==ne[5] && old[5]==ne[3] && old[6]==ne[4]) {
			// left1
//			System.out.println("l1");
			return true;
		}
		if(old[1]==ne[1] && old[2]==ne[2] && old[3]==ne[4] && old[4]==ne[3] && old[5]==ne[6] && old[6]==ne[5] ) {
//			System.out.println("l2");
			return true;
		}
		if(old[1]==ne[1] && old[2]==ne[2] && old[3]==ne[5] && old[4]==ne[6] && old[5]==ne[4] && old[6]==ne[3]) {
//			System.out.println("l3");
			return true;
		}
		return false;
	}
}
