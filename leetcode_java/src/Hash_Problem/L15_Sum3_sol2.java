package Hash_Problem;
import java.util.*;
public class L15_Sum3_sol2 {
	/*A more simple solution in O(n^2)
		1. Sort the array.
		2. Loop first loop with index i.
		3. Initialize two index j = i + 1 & k from the end k = n - 1
		4. loop until j < k
		5. calculate sum = nums[i] + nums[j] + nums[k]
		6. check sum and update pointer j & k
			a. sum = 0 => we found triplet add into set and j++, k--
			b. sum > 0 => k--
			c. sum < 0 => j++
	 * 
	 * 
	 * */
	    public List<List<Integer>> threeSum(int[] nums) {
	        if (nums.length < 3) return new ArrayList<>(); // if nums less than 3 element
	        // Java 排序快捷
	        Arrays.sort(nums); // sort array
	        Set<List<Integer>> set = new HashSet<>();
	        for (int i = 0; i < nums.length - 2; i++) {
	            int j = i + 1;
	            int k = nums.length - 1;
	            while (j < k) {
	                int sum = nums[i] + nums[j] + nums[k];
	                if (sum == 0) set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
	                else if (sum > 0) k--;
	                else if (sum < 0) j++;
	            }

	        }
	        // 从HashSet 转ArrayList快捷
	        return new ArrayList<>(set);
	    }
	
}
