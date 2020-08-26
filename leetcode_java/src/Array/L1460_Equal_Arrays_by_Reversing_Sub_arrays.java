package Array;
import java.util.*;
// 翻转数字相当于冒泡排序了，所以只要array的内容和出现字数一致就是Equal
public class L1460_Equal_Arrays_by_Reversing_Sub_arrays {
	public boolean canBeEqual(int[] target, int[] arr) {
		Map<Integer, Integer> tarMap = new HashMap<>();
		Map<Integer, Integer> arrMap = new HashMap<>();
		for(int i=0;i<target.length; i++) {
			if(tarMap.containsKey(target[i])) {
				tarMap.replace(target[i], tarMap.get(target[i])+1);
			}
			else {
				tarMap.put(target[i], 1);
			}
		}
		for(int i=0;i<arr.length; i++) {
			if(arrMap.containsKey(arr[i])) {
				arrMap.replace(arr[i], arrMap.get(arr[i])+1);
			}
			else {
				arrMap.put(arr[i], 1);
			}
		}
		for(Map.Entry<Integer, Integer> entry : tarMap.entrySet()) {
			if(arrMap.containsKey(entry.getKey())) {
				if(arrMap.get(entry.getKey()) != entry.getValue()) {
					return false;
				}
			}else {
				return false;
			}
		}
		return true;
		
	}
	public static void main(String args[]) {
		L1460_Equal_Arrays_by_Reversing_Sub_arrays sol = new L1460_Equal_Arrays_by_Reversing_Sub_arrays();
		int [] target = {1,1,1,1,1};
		int [] arr = {1,1,1,1,1};
		System.out.println(sol.canBeEqual(target, arr));
	}
}
