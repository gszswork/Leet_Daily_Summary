package Hash_Problem;

import java.util.HashMap;
// Hash MAP 
public class Sum2 {
	public int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		HashMap<Integer, Integer> hash = new HashMap<>();
		int [] res = new int [2];
		for(int i =0; i< length; i++) {
			int complement = target - nums[i];
			if(hash.containsKey(complement)) {
				res[0] = i; res[1] = hash.get(complement);
			}
			hash.put(nums[i], i);
		}
		return res;
	}
	public static void main(String args[]) {
		Sum2 s = new Sum2();
		int [] nums = {2, 7, 11, 15};
		System.out.println(s.twoSum(nums, 9));
	}
}
