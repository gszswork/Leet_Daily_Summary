import java.util.*;
public class Arrays_sort_MATRIX {
	public static void main(String args[]) {
		int [][] nums = new int [10][2];
		Arrays.sort(nums, new Comparator<int[]>() {
			public int compare(int[] a, int[] b){
				if(a[0]==b[0]){
					return a[1] - b[1];
				}else {
					return a[0] - b[0];
				}
			}
		});
	}
}
