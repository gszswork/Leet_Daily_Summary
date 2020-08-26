package Simple_Leet_Problem.Array;
import java.util.*;
// 求最大公约数
public class L914_X_of_a_Kind_in_a_Deck_of_Cards {
	public boolean hasGroupsSizeX(int[] deck) {
		int nums [] = new int [10001];
		for (int d: deck) {
			nums[d] ++;
		}
		int g = 0;
		for( int i =0; i<10001; i++) {
			if(nums[i] > 0) {
				g = gcd(g, nums[i]);
				if (g ==1) return false;        //     ^
			}									//     |
		}										//     |
		return g>=2; //实际这里可以直接返回true，因为g==1从这里已经返回false了，并且g由于gcd函数也不可能等于0
	//	return true;
	}
	int gcd( int x, int y) {
		return x==0? y: gcd(y%x, x);
	}
}
